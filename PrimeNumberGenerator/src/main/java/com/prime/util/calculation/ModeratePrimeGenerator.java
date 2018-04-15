package com.prime.util.calculation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.beans.PrimeBean;

/**
 * This algorithm is use to get the list of prime numbers using Sieve of
 * Eratosthenes.
 * 
 * @author Pooja Kumbhar
 * @see <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Wikipedia
 *      article on Sieve of Eratosthenes</a>
 */
public class ModeratePrimeGenerator {
	PrimeBean bean;
	private static final Logger logger = LoggerFactory.getLogger(ModeratePrimeGenerator.class);

	public ArrayList<Long> primeNumberGenerator(long startRange, long endRange, String stratergy) throws SQLException {
		logger.info("Inside ModeratePrimeGenerator.... ");
		boolean flag[] = new boolean[(int) (endRange + 1)];
		ArrayList<Long> primeNumbers = new ArrayList<>();
		Arrays.fill(flag, true);
		for (long num = 2; num * num <= endRange; num++) {
			// If flag[p] is not changed, then it is a prime
			if (flag[(int) num] == true) {
				// Update all multiples of num
				for (long i = num * 2; i <= endRange; i += num)
					flag[(int) i] = false;
			}
		}

		for (long i = 2; i <= endRange; i++) {
			if (flag[(int) i] == true) {
				primeNumbers.add(i);
			}

		}
		logger.info("Prime numbers using ModeratePrimeGenerator: " + primeNumbers);
		return primeNumbers;
	}
}
