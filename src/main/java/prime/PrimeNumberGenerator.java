package prime;

import java.util.List;

/**
 * Created by mrd on 2/13/17.
 */
public interface PrimeNumberGenerator {

    List<Integer> generate(int startingValue, int endingValue);

    boolean isPrime(int value);

}
