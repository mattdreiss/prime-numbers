package prime;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * The Sieve of Eratosthenes is an algorithm that aims to determine which of the integer in a range from 1 to n
 * are composite. Once the composite integers are identified, the remaining integers in the range are the primes.
 *
 * A BitSet is used to store composite number table as it takes less memory than an array of booleans. The most memory
 * is used in collecting the primes into a list.
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
