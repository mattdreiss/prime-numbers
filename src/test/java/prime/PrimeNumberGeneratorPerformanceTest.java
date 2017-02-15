package prime;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrd on 2/14/17.
 */
public class PrimeNumberGeneratorPerformanceTest {

    private PrimeNumberGeneratorImpl generator;

    @Before
    public void setup() {
        this.generator = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void performanceTest() {
        int i = 0;
        int iterations = 1;
        int primeRangeEnd = 1000000000;

        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        while (i < iterations) {
            generator.generate(1, primeRangeEnd);
            i++;
        }
        stopwatch.stop();
        System.out.println("Generation time: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");

    }

}