package com.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.ScenarioDetails;

@Repository
public interface ScenarioDetailsRepository extends JpaRepository<ScenarioDetails, Long> {

//	@Query("select o from ScenarioDetails o where scenario_id in :ids")
//	public List<ScenarioDetails> getByScenarioIds(@Param("ids") List<Long> idList);
}
