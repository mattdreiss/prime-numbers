package prime;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrd on 2/14/17.
 */
public class PrimeNumberGeneratorPerformanceTest {

    private PrimeNumberGenerator generator;

    private PrimeNumberGenerator eratosthenesGenerator;

    @Before
    public void setup() {
        this.generator = new DivisionPrimeNumberGenerator();
        this.eratosthenesGenerator = new SieveOfEratosthenesGenerator();
    }

    /**
     * Displays the performance difference between the divisor method and the sieve of Eratosthenes in generating a
     * range of primes between 1 and 1 million.
     */
    @Test
    public void performanceTest() {
        int primeRangeEnd = 1000000;

        Stopwatch stopwatch = Stopwatch.createStarted();
        generator.generate(1, primeRangeEnd);
        stopwatch.stop();

        System.out.println("Division generation time: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

        stopwatch.reset();
        stopwatch.start();
        eratosthenesGenerator.generate(1, primeRangeEnd);
        stopwatch.stop();

        System.out.println("Eratosthenes generation time: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    /**
     * Displays the performance difference between the divisor method and the sieve of Eratosthenes in determining if
     * the maximum Java integer is prime or not.
     *
     * This is a long running test.
     * The Eratosthenes generation averaged 30 second execution time on a second generation Intel i7.
     */
    @Test
    public void isPrime_maxInt() throws Exception {

        Stopwatch stopwatch = Stopwatch.createStarted();
        generator.isPrime(Integer.MAX_VALUE);
        stopwatch.stop();

        System.out.println("Division max integer prime test: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

        stopwatch.reset();
        stopwatch.start();
        eratosthenesGenerator.isPrime(Integer.MAX_VALUE);
        stopwatch.stop();

        System.out.println("Eratosthenes max integer prime test: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    /**
     * Displays the performance metrics of generating the full range of primes between 1 and max integer.
     *
     * This is a long running test.
     * Averaged 67 second execution time on a second generation Intel i7.
     */
    @Test
    public void generateMaxIntRange() throws Exception {

        Stopwatch stopwatch = Stopwatch.createStarted();
        eratosthenesGenerator.generate(1, Integer.MAX_VALUE);
        stopwatch.stop();

        System.out.println("Eratosthenes max integer generation test: " + stopwatch.elapsed(TimeUnit.SECONDS) + "s");
    }

}