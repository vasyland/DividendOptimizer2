package com.stock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.exceptions.ActionNotFoundException;
import com.stock.model.Action;
import com.stock.repositories.ActionRepository;

@Service
public class ActionServiceImpl implements ActionService {
	
	private final ActionRepository actionRepository;
	
	public ActionServiceImpl(ActionRepository actionRepository) {
		super();
		this.actionRepository = actionRepository;
	}

	@Override
	public Action save(Action a) {
		return actionRepository.save(a);
	}

	
	@Override
	public Action update(Action a) {
		Action existingAction = actionRepository.findById(a.getId()).orElse(null);
		if (existingAction == null) {
			return actionRepository.save(a);
		}
		existingAction.setSymbol(a.getSymbol());
		existingAction.setQuantity(a.getQuantity());
		existingAction.setActivity(a.getActivity());
		existingAction.setPrice(a.getPrice());
		existingAction.setCommisions(a.getCommisions());
		existingAction.setCurrency(a.getCurrency());
		existingAction.setActivity_date(a.getActivity_date());

		return actionRepository.save(existingAction);
	}
	
	/* TODO: Work on return values */
	@Override
	public void deleteById(Long id) {
		actionRepository.deleteById(id);
	}

	@Override
	public Action findById(Long id) {
		return actionRepository.findById(id)
				.orElseThrow(() -> new ActionNotFoundException("Action transaction by id " + id + " was not found"));
	}

	@Override
	public List<Action> findByScenarioId(Long id) {
		
		return (List<Action>) actionRepository.findByScenarioId(id)
					.orElseThrow(() -> new ActionNotFoundException("Action transactions by Scenario id " + id + " was not found"));
	}

	
	/*
	 * TODO: 
	 */
	@Override
	public int deleteByScenarioId(Long id) {
		return actionRepository.deleteByScenarioId(id);
	}

}
