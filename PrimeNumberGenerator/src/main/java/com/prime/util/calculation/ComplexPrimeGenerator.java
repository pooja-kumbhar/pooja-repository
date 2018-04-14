package com.prime.util.calculation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Pooja
 *
 */
public class ComplexPrimeGenerator  {
    
    public List<Long> primeNumberGenerator(long startRange, long endRange, String strategy) throws SQLException {
        List<Long> result = new ArrayList<>();

        // change start to 2 if it is less than 2.
        startRange = startRange < 2 ? 2 : startRange;
        // if it is a range such as (-100, 1), return empty list
        if (endRange < startRange) return result;

        long lowerLimit = 2;
        long upperLimit = (int) Math.sqrt(endRange);

        List<Long> primes = new ModeratePrimeGenerator().primeNumberGenerator(lowerLimit, upperLimit,strategy);

        boolean[] isPrime = new boolean[(int) (endRange - startRange + 1)];
        Arrays.fill(isPrime, true);

        for (long prime : primes) {
            int lowLimit = (int) (Math.floor(startRange / prime) * prime);
            if (lowLimit < startRange) lowLimit += prime;

            for (int j = lowLimit; j <= endRange; j += prime) {
                if (j != prime)
                    isPrime[(int) (j - startRange)] = false;
            }
        }

        for (long i = startRange; i <= endRange; i++) {
            if (isPrime[(int) (i - startRange)]) result.add((long) i);
        }

        return result;
    }
}