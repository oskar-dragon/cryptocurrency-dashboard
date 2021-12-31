package com.dragcorp.cryptodashboard.api;

import com.dragcorp.cryptodashboard.data.Dashboard;
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

  @GetMapping(value = "/{currency}/{chartDays}")
  public Dashboard getDashboardData(@PathVariable("currency") String currency,
                                    @PathVariable("chartDays") String chartDays) {
    return dashboardDataService.getDashboardData(currency, chartDays);
  }
}
