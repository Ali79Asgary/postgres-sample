package com.mirbozorgi.postgresql.api.plugin.interceptors;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("loggerInterceptor")
public class ApiLoggerInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(ApiLoggerInterceptor.class);

  @Override
  public boolean preHandle(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final Object handler) throws Exception {

    String url = request.getServletPath();

    Object rawParameters = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

    if (rawParameters != null) {

      Map<String, String> pathParameters = (Map) rawParameters;

      for (Map.Entry<String, String> item : pathParameters.entrySet()) {
        MDC.put(item.getKey(), item.getValue());
        url = url.replace(String.format("%s/%s", item.getKey(), item.getValue()),
            String.format("%s/-", item.getKey()));
      }
    }

    request.getParameterMap().forEach((key, value) -> MDC.put(key, value[0]));

    MDC.put("end_point", url);

    logger.info(request.getServletPath());

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object object, Exception arg3)
      throws Exception {
    MDC.clear();
  }
}