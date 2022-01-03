package com.dragcorp.cryptodashboard.controller;

import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.service.CoinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coin")
@AllArgsConstructor
public class CoinController {
  private final CoinService coinService;

  @GetMapping(value = "/{id}")
  public Coin getCoinData(@PathVariable("id") String id,
                          @RequestParam("currency") String currency,
                          @RequestParam("ohlcdays") int ohlcDays) {
    return coinService.getCoinData(id, currency, ohlcDays);
  }
}
