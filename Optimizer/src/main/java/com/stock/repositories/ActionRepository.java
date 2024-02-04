package com.stock.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stock.model.Action;

public interface ActionRepository extends CrudRepository<Action, Long> {

//	@Query("select o from ScenarioDetails o where scenario_id in :ids")
//	public List<ScenarioDetails> getByScenarioIds(@Param("ids") List<Long> idList);
}
