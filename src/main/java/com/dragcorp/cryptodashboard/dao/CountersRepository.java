package com.dragcorp.cryptodashboard.dao;

import com.dragcorp.cryptodashboard.data.Counters;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CountersRepository extends MongoRepository<Counters, String> {
}
