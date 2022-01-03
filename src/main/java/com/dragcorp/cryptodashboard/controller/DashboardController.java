package com.dragcorp.cryptodashboard.controller;

import com.dragcorp.cryptodashboard.model.Dashboard;
import com.dragcorp.cryptodashboard.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/dashboard")
@AllArgsConstructor
public class DashboardController {
  private final DashboardService dashboardDataService;

  @GetMapping(value = "/{currency}")
  public Dashboard getDashboardData(@PathVariable("currency") String currency) {
    return dashboardDataService.getDashboardData(currency);
  }
}
