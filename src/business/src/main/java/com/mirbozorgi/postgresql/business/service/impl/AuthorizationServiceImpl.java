package com.mirbozorgi.postgresql.business.service.impl;

import com.mirbozorgi.postgresql.business.service.AuthorizationService;
import com.mirbozorgi.postgresql.business.service.SerializerService;
import com.mirbozorgi.postgresql.core.domain.security.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

  @Autowired
  SerializerService commonService;

  @Override
  public void register(Long playerId, String token) {


  }

  @Override
  public AuthorizationInfo authorize(String token) {

    return new AuthorizationInfo(Long.parseLong(token));
  }
}
