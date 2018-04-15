package com.prime.beans;

import java.util.List;

/**
 * This bean is use for representing prime numbers result.
 * 
 * @author Pooja Kumbhar
 *
 */
public class PrimeBean {

	long startRange;
	long endRange;
	String stratergy;
	List<Long> primeNumbers;
	long count;
	long executionTime;

	public PrimeBean(long startRange, long endRange, String stratergy, List<Long> primeNumbers, long count,
			long executionTime) {
		this.startRange = startRange;
		this.endRange = endRange;
		this.stratergy = stratergy;
		this.primeNumbers = primeNumbers;
		this.count = count;
		this.executionTime = executionTime;
	}

	public long getStartRange() {
		return startRange;
	}

	public void setStartRange(long startRange) {
		this.startRange = startRange;
	}

	public long getEndRange() {
		return endRange;
	}

	public void setEndRange(long endRange) {
		this.endRange = endRange;
	}

	public String getStratergy() {
		return stratergy;
	}

	public void setStratergy(String stratergy) {
		this.stratergy = stratergy;
	}

	public List<Long> getPrimeNumbers() {
		return primeNumbers;
	}

	public void setPrimeNumbers(List<Long> primeNumbers) {
		this.primeNumbers = primeNumbers;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "\nStart Range: " + startRange + "\nEnd Range: " + endRange + "\nStrategy :" + stratergy
				+ "\nPrime Numbers :" + primeNumbers.toString() + "\nCount :" + count + "\nExecution Time :"
				+ executionTime + " ms";
	}
}
