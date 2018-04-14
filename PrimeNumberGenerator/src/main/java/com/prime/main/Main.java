package com.prime.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.beans.PrimeBean;
import com.prime.db.PersistanceManager;
import com.prime.util.calculation.ComplexPrimeGenerator;
import com.prime.util.calculation.ModeratePrimeGenerator;
import com.prime.util.calculation.SimplePrimeGenerator;

/**
 * This class is used for generating prime numbers using input from user.
 * 
 * @author Pooja Kumbhar
 *
 */
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {

		List<Long> result = new ArrayList<>();
		long startRange;
		long endRange;
		String stratergy;
		long startTime;
		long endTime;
		PrimeBean bean;

		startRange = Long.parseLong(args[0]);
		endRange = Long.parseLong(args[1]);
		stratergy = args[2];

		logger.info("\nProgram Input----------------------------------------------------------\nStart Range: "
				+ startRange + "\nEnd Range: " + endRange + "\nStrategy :" + stratergy);

		try {
			switch (stratergy) {
			case "Stategy1":
				startTime = System.currentTimeMillis();
				result = new SimplePrimeGenerator().primeNumberGenerator(startRange, endRange, stratergy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, stratergy, result, result.size(), endTime - startTime);
				new PersistanceManager(bean).store();
				logger.info("Prime number bean", bean.toString());
				break;
				
			case "Stategy2":
				startTime = System.currentTimeMillis();
				result = new ModeratePrimeGenerator().primeNumberGenerator(startRange, endRange, stratergy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, stratergy, result, result.size(), endTime - startTime);
				new PersistanceManager(bean).store();
				logger.info("Prime number bean", bean.toString());
				break;
				
			case "Stategy3":
				startTime = System.currentTimeMillis();
				result = new ComplexPrimeGenerator().primeNumberGenerator(startRange, endRange, stratergy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, stratergy, result, result.size(), endTime - startTime);
				new PersistanceManager(bean).store();
				logger.info("Prime number bean", bean.toString());
				break;
			default:
				logger.info("Invalid Stratergy.");

			}
			logger.info(
					"\nProgram Output----------------------------------------------------------\n" + result.toString());

		} catch (Exception e) {
			logger.error("Exception :", e);
		}

	}

}
