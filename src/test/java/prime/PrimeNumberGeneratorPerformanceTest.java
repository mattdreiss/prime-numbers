package prime;

import com.google.common.base.Stopwatch;
import org.junit.Before;
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
        this.generator = new PrimeNumberGeneratorImpl();
        this.eratosthenesGenerator = new SieveOfEratosthenesGenerator();
    }

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

}