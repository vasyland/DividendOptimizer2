package com.stock.services;

import java.util.List;
import com.stock.model.SymbolStatus;

public interface SymbolService {

	List<String> getSymbols();
	List<SymbolStatus> getRecomendedBuySymbols();
}
