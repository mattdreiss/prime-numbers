package prime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrd on 2/13/17.
 */
public class DivisionPrimeNumberGenerator implements PrimeNumberGenerator {

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        int start = startingValue;
        int end = endingValue;
        List<Integer> primes = new ArrayList<>();

        if (startingValue > endingValue) {
            start = endingValue;
            end = startingValue;
        }

        while (start <= end) {
            if (isPrime(start)) {
                primes.add(start);
            }
            start++;
        }

        return primes;
    }

    @Override
    public boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        if (value < 4) {
            return true;
        }

        if (value % 2 == 0 || value % 3 == 0) {
            return false;
        }

        int maxDivisor = (int) Math.sqrt(value) + 1;

        for (int i = 5; i < maxDivisor; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

}
