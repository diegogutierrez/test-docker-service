package com.example.testservice.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

  @GetMapping(path = "/get")
  public Map<String, Object> get() {
    return Map.of("endpoint", "get");
  }

  @GetMapping(path = "/get/delaysec/{delaysec}")
  public Map<String, Object> getDelay(@PathVariable("delaysec") long delaySec) {
    try {
      Thread.sleep(delaySec * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return Map.of("endpoint", "getDelay");
  }
}
