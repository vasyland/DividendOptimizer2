package com.stock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stock.exceptions.ActionNotFoundException;
import com.stock.exceptions.ScenarioNotFoundException;
import com.stock.model.Action;
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
				.orElseThrow(() -> new ScenarioNotFoundException("Scenario by id " + id + " not found"));
	}

	@Override
	public void deleteById(Long id) {
		scenarioRepository.deleteById(id);
	}

	@Override
	public List<Scenario> findByUserId(Long id) {
		// TODO Auto-generated method stub
		//return Optional.empty();
		return (List<Scenario>) scenarioRepository.findByUserId(id)
				.orElseThrow(() -> new ActionNotFoundException("Scenarios by User id " + id + " not found"));
	}
}
