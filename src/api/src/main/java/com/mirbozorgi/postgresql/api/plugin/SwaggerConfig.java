package com.mirbozorgi.postgresql.api.plugin;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

  /**
   * swagger config.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("games.medrick.postgresql.api.controller"))
        .paths(PathSelectors.any())
        .build()
        .genericModelSubstitutes(ResponseEntity.class)
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {

    ApiInfo apiInfo = new ApiInfo("postgresql server",
        "an online interactive book store!"
            + "\n\n"
            + "    {\n\n"
            + "    \"msg\": \"ok\",\n\n"
            + "    \"data\": {} "
            + "    \n\n"
            + "    }"
            + "\n\n "
            + "and your response is in \"data\" object",

        "0.2.0", "http://games.medrick.postgresql",
        new Contact("medrick", "http://www.medrickgames.com", "info@medrckgames.com"),
        "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", new ArrayList<>());
    return apiInfo;
  }
}