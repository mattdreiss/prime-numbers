package prime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrd on 2/13/17.
 */
public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        int pos = startingValue;
        int rangeEnd = endingValue;
        List<Integer> primes = new ArrayList<>();

        if (startingValue > endingValue) {
            pos = endingValue;
            rangeEnd = startingValue;
        }

        while (pos <= rangeEnd) {
            if (isPrime(pos)) {
                primes.add(pos);
            }
            pos++;
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
