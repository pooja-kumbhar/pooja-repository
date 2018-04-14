package com.prime.util.calculation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.beans.PrimeBean;
import com.prime.db.PersistanceManager;
/**
 * 
 * @author Pooja
 *
 */
public class SimplePrimeGenerator {

	PrimeBean bean;
	private static final Logger logger = LoggerFactory.getLogger(SimplePrimeGenerator.class);

	public List<Long> primeNumberGenerator(long startRange, long endRange, String stratergy) throws SQLException {
		long startTime = System.currentTimeMillis();
		long i = 0;
		long num = 0;

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
		long endTime = System.currentTimeMillis();
		bean = new PrimeBean(startRange, endRange, stratergy, primeNumbers, primeNumbers.size(), endTime - startTime);
		new PersistanceManager(bean).store();
		logger.info("Prime number bean", bean.toString());
		return primeNumbers;
	}
}
