package com.stock.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stock.model.Scenario;

public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
}
