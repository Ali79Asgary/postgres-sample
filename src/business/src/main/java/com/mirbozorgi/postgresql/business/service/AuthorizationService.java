package com.mirbozorgi.postgresql.business.service;


import com.mirbozorgi.postgresql.core.domain.security.AuthorizationInfo;

public interface AuthorizationService {

  void register(Long playerId, String token);

  AuthorizationInfo authorize(String token);
}
