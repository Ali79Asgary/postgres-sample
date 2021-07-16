package com.mirbozorgi.postgresql.api.exception;


import com.mirbozorgi.postgresql.core.exception.CustomException;

public class InvalidMarketException extends CustomException {

  public InvalidMarketException() {
    super("invalid_market");
  }
}
