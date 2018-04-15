package com.prime.util.calculation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is linear basic algorithm to calculate prime numbers.
 * 
 * @author Pooja Kumbhar
 *
 */
public class SimplePrimeGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(SimplePrimeGenerator.class);

	public List<Long> primeNumberGenerator(long startRange, long endRange, String stratergy) throws SQLException {
		long i = 0;
		long num = 0;
		logger.info("Inside SimplePrimeGenerator.... ");
		List<Long> primeNumbers = new ArrayList<>();

		for (i = startRange; i <= endRange; i++) {
			int counter = 0;
			for (num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				// Appended the Prime number to the String
				primeNumbers.add(i);
			}
		}
		logger.info("Prime numbers using SimplePrimeGenerator: "+primeNumbers);
		return primeNumbers;
	}
}
