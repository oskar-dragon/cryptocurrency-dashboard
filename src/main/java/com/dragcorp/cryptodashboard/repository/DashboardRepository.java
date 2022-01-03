package com.dragcorp.cryptodashboard.repository;

import com.dragcorp.cryptodashboard.model.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardRepository extends MongoRepository<Dashboard, String> {
}
