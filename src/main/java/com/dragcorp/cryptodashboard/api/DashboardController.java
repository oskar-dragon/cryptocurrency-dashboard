package com.dragcorp.cryptodashboard.api;

import com.dragcorp.cryptodashboard.data.Coin;
import com.dragcorp.cryptodashboard.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/dashboard")
@AllArgsConstructor
public class DashboardController {

  private final DashboardService dashboardDataService;

  @GetMapping
  public List<Coin> getData() {
    return dashboardDataService.getDashboardData();
  }
}
