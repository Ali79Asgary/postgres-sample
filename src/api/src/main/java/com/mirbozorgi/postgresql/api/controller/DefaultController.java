package com.mirbozorgi.postgresql.api.controller;

import com.mirbozorgi.postgresql.api.util.helper.ResponseHelper;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class DefaultController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public ResponseEntity error() {
    return ResponseHelper.response("invalid address", "not_found", HttpStatus.NOT_FOUND);
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }
}
