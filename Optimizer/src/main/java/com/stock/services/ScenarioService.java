package com.stock.services;

import java.util.List;
import com.stock.model.Scenario;

public interface ScenarioService {
	public Scenario addScenario(Scenario scenario);
	public List<Scenario> findAll();	
	public Scenario updateScenario(Scenario scenario);
	public void deleteScenario(Long id);
	public Scenario findScenarioById(Long id);
}
