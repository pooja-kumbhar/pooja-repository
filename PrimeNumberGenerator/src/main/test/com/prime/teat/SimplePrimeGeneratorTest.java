package com.prime.teat;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.prime.util.calculation.SimplePrimeGenerator;

import junit.framework.TestCase;

public class SimplePrimeGeneratorTest extends TestCase {

	long startRange;
	long endRange;
	String strategy;
	

	@Test
	public void testPrimeGeneratorNotNull() {
		long startRange = 10;
		long endRange = 100;
		String strategy = "Stategy1";
		List<Long> result;
		try {
			result =new SimplePrimeGenerator().primeNumberGenerator(startRange, endRange, strategy);
			assertNotNull(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
