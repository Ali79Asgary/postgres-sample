package com.mirbozorgi.postgresql.api.plugin.interceptors;

import com.mirbozorgi.postgresql.api.exception.ForceUpdateException;
import com.mirbozorgi.postgresql.api.exception.InvalidClientVersionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("clientversioninterceptor")
public class ClientVersionInterceptor extends HandlerInterceptorAdapter {

  private static final String CLIENT_VERSION_HEADER = "client-version";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String clientVersionRaw = request.getHeader(CLIENT_VERSION_HEADER);

    Integer clientVersion = 0;


    return true;
  }
}