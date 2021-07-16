package com.mirbozorgi.postgresql.api.exception;

import com.mirbozorgi.postgresql.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends CustomException {

  public UnAuthorizedException() {
    super("unauthorized", HttpStatus.UNAUTHORIZED);
  }

}
