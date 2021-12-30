package com.dragcorp.cryptodashboard.api;

import com.dragcorp.cryptodashboard.data.Counters;
import com.dragcorp.cryptodashboard.service.CountersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/counters")
@AllArgsConstructor
public class CountersController {

  private final CountersService countersDataService;

  @GetMapping
  public Counters getData() {
    return countersDataService.getCountersData();
  }
}