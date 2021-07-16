package com.mirbozorgi.postgresql.api.controller;

import com.mirbozorgi.postgresql.core.repository.entity.DBHealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class HealthController {


  @Autowired
  private DBHealthRepository dbHealthRepository;


  @RequestMapping(value = "/health", method = RequestMethod.GET, produces = "text/plain")
  public String monitor() {

    int db_check = 0;
    int redis_check = 0;
    int app_check = 1;

    StringBuilder builder = new StringBuilder();

    try {
      db_check = dbHealthRepository.check() > 0 ? 1 : 0;
    } catch (Exception ex) {
    }

    String result =
        String.format(
            "medrick_app %d \n" + "medrick_db %d \n" + "medrick_redis %d \n",
            app_check, db_check, redis_check);

    builder.append(result);

    return builder.toString();
  }
}
