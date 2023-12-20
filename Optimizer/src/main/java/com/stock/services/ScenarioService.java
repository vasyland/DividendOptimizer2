package com.stock.services;

import java.util.List;
import com.stock.model.Scenario;
import com.stock.model.ScenarioDetails;

public interface ScenarioService {
	public Scenario addScenario(Scenario scenario);
	public List<Scenario> findAll();	
	public Scenario updateScenario(Scenario scenario);
	public void deleteScenario(Long id);
	public Scenario findScenarioById(Long id);
	
	//public List<ScenarioDetails> getByScenarioIds(List<Long> idList);
	public ScenarioDetails addScenarioDetails(ScenarioDetails scenarioDetails);
}