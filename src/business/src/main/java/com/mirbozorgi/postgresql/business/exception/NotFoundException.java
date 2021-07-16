package com.mirbozorgi.postgresql.business.exception;

import com.mirbozorgi.postgresql.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException {

  public NotFoundException() {
    super("not_found", HttpStatus.NOT_FOUND);
    this.setData("not_found");
  }
}
