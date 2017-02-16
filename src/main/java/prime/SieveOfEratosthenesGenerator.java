package prime;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by mrd on 2/15/17.
 */
public class SieveOfEratosthenesGenerator implements PrimeNumberGenerator {

    private BitSet buildCompositeNumberTable(int endingValue) {
        BitSet compositeTable = new BitSet(endingValue);

        int maxDivisor = (int) Math.sqrt(endingValue);

        for (int i = 2; i <= maxDivisor; i++) {
            if (!compositeTable.get(i)) {
                for (int j = i + i; j <= endingValue && j > 0; j += i) {
                    if (!compositeTable.get(j)) {
                        compositeTable.flip(j);
                    }
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

        BitSet compositeNumberTable = buildCompositeNumberTable(end);
        List<Integer> primes = new ArrayList<>();

        for (int i = 0; i < compositeNumberTable.length(); i++) {
            if (!compositeNumberTable.get(i) && i >= start) {
                primes.add(i);
            }
        }

        return primes;
    }

    @Override
    public boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        BitSet compositeNumberTable = buildCompositeNumberTable(value);
        return !compositeNumberTable.get(value);
    }
}
