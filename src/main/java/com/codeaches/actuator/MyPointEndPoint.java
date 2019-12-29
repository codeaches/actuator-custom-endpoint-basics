package com.codeaches.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
 * Make sure not to use any upper case character values in ID of @Endpoint
 */
@Component
@Endpoint(id = "weather")
public class MyPointEndPoint {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  @ReadOperation
  public String check() {
    return restTemplate.getForObject("https://api.weather.gov", String.class);
  }
}