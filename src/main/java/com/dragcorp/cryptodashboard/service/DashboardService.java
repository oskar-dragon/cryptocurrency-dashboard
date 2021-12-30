package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.data.Coin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DashboardService {
  public List<Coin> getDashboardData() {
    return new ArrayList<>(10);
  }
}
