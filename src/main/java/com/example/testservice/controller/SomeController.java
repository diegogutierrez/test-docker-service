package com.example.testservice.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

  private static final Logger log = LoggerFactory.getLogger(SomeController.class);

  @GetMapping(path = "/get")
  public Map<String, Object> get() {
    log.info("received request, path: /get");
    return Map.of("endpoint", "get");
  }

  @GetMapping(path = "/get/delaysec/{delaysec}")
  public Map<String, Object> getDelay(@PathVariable("delaysec") long delaySec) {
    log.info("received request, path: /get/delaysec/" + delaySec);
    try {
      Thread.sleep(delaySec * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return Map.of("endpoint", "getDelay");
  }
}
