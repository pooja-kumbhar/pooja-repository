package com.prime.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.prime.util.calculation.SimplePrimeGenerator;

import junit.framework.TestCase;

public class SimplePrimeGeneratorTest extends TestCase {
	SimplePrimeGenerator primeGenerator;
	long startRange;
	long endRange;
	String statergy;
	List<Long> number;

	Scanner scanner = new Scanner(System.in);

	@Test
	public void primeNumGeneratorTest() throws SQLException {
		primeGenerator = new SimplePrimeGenerator();
		startRange = scanner.nextLong();
		endRange = scanner.nextLong();
		statergy = scanner.next();
		number = primeGenerator.primeNumberGenerator(startRange, endRange, statergy);
		assertNotNull(number);
	}

}
