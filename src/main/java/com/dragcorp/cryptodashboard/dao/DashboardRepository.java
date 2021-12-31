package com.dragcorp.cryptodashboard.dao;

import com.dragcorp.cryptodashboard.data.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardRepository extends MongoRepository<Dashboard, String> {
}
