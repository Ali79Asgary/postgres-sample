package com.mirbozorgi.postgresql.api.exception;


import com.mirbozorgi.postgresql.core.exception.CustomException;

public class MaintenanceException extends CustomException {

  public MaintenanceException() {
    super("maintenance_mode");
  }

  public MaintenanceException(String msg) {
    this();
    this.setMsg(msg);
  }
}
