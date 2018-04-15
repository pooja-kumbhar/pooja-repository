package com.prime.teat;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.prime.util.calculation.ComplexPrimeGenerator;

public class ComplexPrimeGeneratorTest {

	long startRange;
	long endRange;
	String strategy;
	

	@Test
	public void testPrimeGeneratorNotNull() {
		long startRange = 10;
		long endRange = 100;
		String strategy = "Stategy3";
		List<Long> result;
		try {
			result = new ComplexPrimeGenerator().primeNumberGenerator(startRange, endRange, strategy);
			assertNotNull(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}