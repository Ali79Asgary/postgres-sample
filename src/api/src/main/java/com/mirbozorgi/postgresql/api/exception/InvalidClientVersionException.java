package com.mirbozorgi.postgresql.api.exception;


import com.mirbozorgi.postgresql.core.exception.CustomException;

public class InvalidClientVersionException extends CustomException {

  public InvalidClientVersionException() {
    super("invalid_client_version");
  }
}
