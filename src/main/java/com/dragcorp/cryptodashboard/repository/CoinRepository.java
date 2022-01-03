package com.dragcorp.cryptodashboard.repository;

import com.dragcorp.cryptodashboard.model.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, String> {
}
