package com.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stock.model.ScenarioDetails;

public interface ScenarioDetailsRepository extends JpaRepository<ScenarioDetails, Long> {

	@Query("select o from ScenarioDetails o where scenario_id in :ids")
	public List<ScenarioDetails> getByScenarioIds(@Param("ids") List<Long> idList);
}
