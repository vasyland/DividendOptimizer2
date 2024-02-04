package com.stock.services;

import java.util.List;
import com.stock.model.Scenario;

public interface ScenarioService {
	public Scenario save(Scenario scenario);
	public List<Scenario> findAll();	
	public Scenario update(Scenario scenario);
	public void deleteById(Long id);
	public Scenario findById(Long id);
}