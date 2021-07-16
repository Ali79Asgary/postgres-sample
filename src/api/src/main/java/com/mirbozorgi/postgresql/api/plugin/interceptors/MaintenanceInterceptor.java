package com.mirbozorgi.postgresql.api.plugin.interceptors;

import com.mirbozorgi.postgresql.api.exception.MaintenanceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("maintenanceInterceptor")
public class MaintenanceInterceptor extends HandlerInterceptorAdapter {


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    return true;
  }
}