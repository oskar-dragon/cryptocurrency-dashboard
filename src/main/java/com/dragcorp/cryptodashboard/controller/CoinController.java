package com.dragcorp.cryptodashboard.controller;

import com.dragcorp.cryptodashboard.model.Coin;
import com.dragcorp.cryptodashboard.service.CoinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coins/{currency}")
@AllArgsConstructor
@CrossOrigin("*")
public class CoinController {
  private final CoinService coinService;

  @GetMapping()
  public Coin getCoin(@PathVariable("currency") String currency,
                      @RequestParam("id") String id,
                      @RequestParam("ohlcdays") int ohlcDays) {
    return coinService.getCoin(id, currency, ohlcDays);
  }

  @GetMapping(value = "/list")
  public List<Coin> getCoins(@PathVariable("currency") String currency) {
    return coinService.getCoins(currency);
  }

  @GetMapping(value="/topgainers/{period}")
  public List<Coin> getTopGainers(@PathVariable("currency") String currency, @PathVariable("period") String period) {
    return coinService.getTopGainers(currency, period);
  }

  @GetMapping(value="/toplosers/{period}")
  public List<Coin> getTopLosers(@PathVariable("currency") String currency, @PathVariable("period") String period) {
    return coinService.getTopLosers(currency, period);
  }
}
