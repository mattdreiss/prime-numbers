package prime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrd on 2/15/17.
 */
public class SieveOfEratosthenesGenerator implements PrimeNumberGenerator {

    private boolean[] buildCompositeNumberTable(int endingValue) {
        boolean[] compositeTable = new boolean[endingValue - 1];

        int maxDivisor = (int) Math.sqrt(endingValue);

        for (int i = 2; i <= maxDivisor; i++) {
            if (!compositeTable[i - 2]) {
                for (int j = i + i; j <= endingValue; j += i) {
                    compositeTable[j - 2] = true;
                }
            }
        }

        return compositeTable;
    }

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        int start = startingValue;
        int end = endingValue;

        if (startingValue > endingValue) {
            start = endingValue;
            end = startingValue;
        }

        if (start < 2) {
            start = 2;
        }

        boolean[] compositeNumberTable = buildCompositeNumberTable(end);
        List<Integer> primes = new ArrayList<>();


        for (int i = 0; i < compositeNumberTable.length; i++) {
            if (!compositeNumberTable[i] && i + 2 >= start) {
                primes.add(i + 2);
            }
        }

        return primes;
    }

    @Override
    public boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        boolean[] compositeNumberTable = buildCompositeNumberTable(value);
        return !compositeNumberTable[value - 2];
    }
}
