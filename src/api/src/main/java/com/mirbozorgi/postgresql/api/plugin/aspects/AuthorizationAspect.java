package com.mirbozorgi.postgresql.api.plugin.aspects;

import com.mirbozorgi.postgresql.api.exception.UnAuthorizedException;
import com.mirbozorgi.postgresql.business.service.AuthorizationService;
import com.mirbozorgi.postgresql.core.domain.security.AuthorizationInfo;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuthorizationAspect {

  @Autowired
  AuthorizationService authorizationService;

  @Before("@annotation(com.mirbozorgi.postgresql.api.plugin.aspects.Authorization)")
  public void authenticate(JoinPoint call) {
    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder
            .currentRequestAttributes())
            .getRequest();

    MethodSignature signature = (MethodSignature) call.getSignature();
    Method method = signature.getMethod();
    Authorization authorization = method.getAnnotation(Authorization.class);

    if (authorization.value()) {

      String accessToken = request.getHeader("access-token");

      if (StringUtils.isEmpty(accessToken)) {
        throw new UnAuthorizedException();
      }

      AuthorizationInfo info = authorizationService.authorize(accessToken);

      MDC.put("token", accessToken);

      if (info.getPlayerId() <= 0) {
        throw new UnAuthorizedException();
      }

      MDC.put("player-id", Long.toString(info.getPlayerId()));

      request.getSession().setAttribute("player-id", info.getPlayerId());
    }
  }
}
