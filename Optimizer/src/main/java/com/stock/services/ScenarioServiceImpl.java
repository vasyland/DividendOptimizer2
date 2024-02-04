package com.stock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.exceptions.ScenarioNotFoundException;
import com.stock.model.Scenario;
import com.stock.repositories.ScenarioRepository;

@Service
public class ScenarioServiceImpl implements ScenarioService {

	private final ScenarioRepository scenarioRepository;

	public ScenarioServiceImpl(ScenarioRepository scenarioRepository) {
		super();
		this.scenarioRepository = scenarioRepository;
	}

	@Override
	public Scenario save(Scenario s) {
		return scenarioRepository.save(s);
	}

	@Override
	public List<Scenario> findAll() {
		return (List<Scenario>) scenarioRepository.findAll();
	}

	@Override
	public Scenario update(Scenario s) {
		return scenarioRepository.save(s);
	}

	@Override
	public Scenario findById(Long id) {
		return scenarioRepository
				.findById(id)
				.orElseThrow(() -> new ScenarioNotFoundException("Scenario by id " + id + " was not found"));
	}

	@Override
	public void deleteById(Long id) {
		scenarioRepository.deleteById(id);
	}
}
