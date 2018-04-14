package com.prime.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.beans.PrimeBean;
import com.prime.db.PersistanceManager;
import com.prime.util.calculation.ComplexPrimeGenerator;
import com.prime.util.calculation.ModeratePrimeGenerator;
import com.prime.util.calculation.SimplePrimeGenerator;

@Path("/primeNumberService")
public class PrimeNumberService {

	private static final Logger logger = LoggerFactory.getLogger(PrimeNumberService.class);
	
	@GET
	@Path("/{startRange}/{endRange}/{statergy}")
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String primeGeneratorService(@PathParam("startRange") long startRange, @PathParam("endRange") long endRange,
			@PathParam("statergy") String strategy) {
		List<Long> result = new ArrayList<>();
		System.out.println("web service called");
		long startTime;
		long endTime;
		PrimeBean bean = null;

		
		logger.info("\nProgram Input----------------------------------------------------------\nStart Range: "
				+ startRange + "\nEnd Range: " + endRange + "\nStrategy :" + strategy);

		try {
			switch (strategy) {
			case "Strategy1":
				startTime = System.currentTimeMillis();
				result = new SimplePrimeGenerator().primeNumberGenerator(startRange, endRange, strategy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, strategy, result, result.size(), endTime - startTime);
				new PersistanceManager(bean).store();
				logger.info("Prime number bean", bean.toString());
				break;
				
			case "Strategy2":
				startTime = System.currentTimeMillis();
				result = new ModeratePrimeGenerator().primeNumberGenerator(startRange, endRange, strategy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, strategy, result, result.size(), endTime - startTime);
				new PersistanceManager(bean).store();
				logger.info("Prime number bean", bean.toString());
				break;
				
			case "Strategy3":
				startTime = System.currentTimeMillis();
				result = new ComplexPrimeGenerator().primeNumberGenerator(startRange, endRange, strategy);
				endTime = System.currentTimeMillis();
				bean = new PrimeBean(startRange, endRange, strategy, result, result.size(), endTime - startTime);
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

		return bean.toString();
	}

}
