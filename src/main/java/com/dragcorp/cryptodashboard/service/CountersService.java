package com.dragcorp.cryptodashboard.service;

import com.dragcorp.cryptodashboard.dao.CountersRepository;
import com.dragcorp.cryptodashboard.data.Counters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CountersService {

  private final CountersRepository repository;

  public Counters getCountersData() {
    return new Counters("bla", "bla", BigDecimal.TEN, LocalDate.now());
  }
}
