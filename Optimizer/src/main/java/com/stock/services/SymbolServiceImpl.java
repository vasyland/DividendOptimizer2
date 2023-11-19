package com.stock.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.stock.repositories.SymbolRepository;

@Service
public class SymbolServiceImpl implements SymbolService {

	private SymbolRepository symbolRepository;
	
	public SymbolServiceImpl(SymbolRepository symbolRepository) {
		super();
		this.symbolRepository = symbolRepository;
	}

	@Override
	public List<String> getSymbols() {
		return symbolRepository.getSymbolForProcessing();
	}

}
