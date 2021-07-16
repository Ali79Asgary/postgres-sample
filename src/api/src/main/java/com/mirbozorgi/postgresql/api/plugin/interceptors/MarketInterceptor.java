package com.mirbozorgi.postgresql.api.plugin.interceptors;

import com.mirbozorgi.postgresql.api.exception.InvalidMarketException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("marketinterceptor")
public class MarketInterceptor extends HandlerInterceptorAdapter {

  private static final String MARKET_HEADER = "market";


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String marketRaw = request.getHeader(MARKET_HEADER);

    request.getSession().setAttribute("market-id", marketRaw);

    return true;
  }
}