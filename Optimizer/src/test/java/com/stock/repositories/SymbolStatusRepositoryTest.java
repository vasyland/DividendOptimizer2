package com.stock.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.stock.model.SymbolStatus;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SymbolStatusRepositoryTest {
	
	@Autowired
	private SymbolStatusRepository symbolStatusRepository;

	/* Run as JUnit Test. Requires to have JUnit ;) */
	public void testGetSymbolsByRecommendedAction() {
		List<SymbolStatus> symbolList = symbolStatusRepository.getSymbolsByRecommendedAction("Buy");
		symbolList.forEach(System.out::println);
	}
}
