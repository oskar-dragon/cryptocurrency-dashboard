package com.dragcorp.cryptodashboard.client.response.coingecko;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinResponse {
  String id;
  String symbol;
  String name;
  String image;
  BigDecimal currentPrice;
  BigDecimal marketCap;
  int marketCapRank;
  BigDecimal fullyDilutedValuation;
  BigDecimal totalVolume;
  BigDecimal high24h;
  BigDecimal low24h;
  BigDecimal priceChange24h;
  BigDecimal priceChangePerc;
  BigDecimal marketCapChange24h;
  float marketCapChangePerc24h;
  BigDecimal circulatingSupply;
  BigDecimal totalSupply;
  BigDecimal maxSupply;
  BigDecimal ath;
  float athChangePerc;
  LocalDate athDate;
  BigDecimal atl;
  float atlChangePerc;
  LocalDate atlDate;
  Roi roi;
  LocalDateTime lastUpdated;

  @JsonCreator
  public CoinResponse(
      @JsonProperty("id") String id,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("name") String name,
      @JsonProperty("image") String image,
      @JsonProperty("current_price") BigDecimal currentPrice,
      @JsonProperty("market_cap") BigDecimal marketCap,
      @JsonProperty("market_cap_rank") int marketCapRank,
      @JsonProperty("fully_diluted_valuation") BigDecimal fullyDilutedValuation,
      @JsonProperty("total_volume") BigDecimal totalVolume,
      @JsonProperty("high_24h") BigDecimal high24h,
      @JsonProperty("low_24h") BigDecimal low24h,
      @JsonProperty("price_change_24h") BigDecimal priceChange24h,
      @JsonProperty("price_change_percentage_24h") BigDecimal priceChangePercDefault,
      @JsonProperty("price_change_percentage_1h_in_currency") BigDecimal priceChangePerc1h,
      @JsonProperty("price_change_percentage_24h_in_currency") BigDecimal priceChangePerc24h,
      @JsonProperty("price_change_percentage_7d_in_currency") BigDecimal priceChangePerc7d,
      @JsonProperty("price_change_percentage_30d_in_currency") BigDecimal priceChangePerc30d,
      @JsonProperty("market_cap_change_24h") BigDecimal marketCapChange24h,
      @JsonProperty("market_cap_change_percentage_24h") float marketCapChangePerc24h,
      @JsonProperty("circulating_supply") BigDecimal circulatingSupply,
      @JsonProperty("total_supply") BigDecimal totalSupply,
      @JsonProperty("max_supply") BigDecimal maxSupply,
      @JsonProperty("ath") BigDecimal ath,
      @JsonProperty("ath_change_percentage") float athChangePerc,
      @JsonProperty("ath_date") LocalDate athDate,
      @JsonProperty("atl") BigDecimal atl,
      @JsonProperty("atl_change_percentage") float atlChangePerc,
      @JsonProperty("atl_date") LocalDate atlDate,
      @JsonProperty("roi") Roi roi,
      @JsonProperty("last_updated") LocalDateTime lastUpdated
  ) {
    this.id = id;
    this.symbol = symbol;
    this.name = name;
    this.image = image;
    this.currentPrice = currentPrice;
    this.marketCap = marketCap;
    this.marketCapRank = marketCapRank;
    this.fullyDilutedValuation = fullyDilutedValuation;
    this.totalVolume = totalVolume;
    this.high24h = high24h;
    this.low24h = low24h;
    this.priceChange24h = priceChange24h;
    if (priceChangePerc1h != null) {
      this.priceChangePerc = priceChangePerc1h;
    } else if (priceChangePerc24h != null) {
      this.priceChangePerc = priceChangePerc24h;
    } else if (priceChangePerc7d != null) {
      this.priceChangePerc = priceChangePerc7d;
    } else if (priceChangePerc30d != null) {
      this.priceChangePerc = priceChangePerc30d;
    } else {
      this.priceChangePerc = priceChangePercDefault;
    }
    this.marketCapChange24h = marketCapChange24h;
    this.marketCapChangePerc24h = marketCapChangePerc24h;
    this.circulatingSupply = circulatingSupply;
    this.totalSupply = totalSupply;
    this.maxSupply = maxSupply;
    this.ath = ath;
    this.athChangePerc = athChangePerc;
    this.athDate = athDate;
    this.atl = atl;
    this.atlChangePerc = atlChangePerc;
    this.atlDate = atlDate;
    this.roi = roi;
    this.lastUpdated = lastUpdated;
  }
}