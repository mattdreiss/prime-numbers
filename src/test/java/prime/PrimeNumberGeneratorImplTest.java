package prime;

import com.google.common.collect.Ordering;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mrd on 2/13/17.
 */
public class PrimeNumberGeneratorImplTest {

    private PrimeNumberGenerator generator;

    @Before
    public void setup() {
        generator = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void isPrime_negative1() throws Exception {
        assertFalse(generator.isPrime(-1));
    }

    @Test
    public void isPrime_0() throws Exception {
        assertFalse(generator.isPrime(0));
    }

    @Test
    public void isPrime_1() throws Exception {
        assertFalse(generator.isPrime(1));
    }

    @Test
    public void isPrime_2() throws Exception {
        assertTrue(generator.isPrime(2));
    }

    @Test
    public void isPrime_3() throws Exception {
        assertTrue(generator.isPrime(3));
    }

    @Test
    public void isPrime_4() throws Exception {
        assertFalse(generator.isPrime(4));
    }

    @Test
    public void isPrime_5() throws Exception {
        assertTrue(generator.isPrime(5));
    }

    @Test
    public void isPrime_9() throws Exception {
        assertFalse(generator.isPrime(9));
    }

    @Test
    public void isPrime_7901() throws Exception {
        assertTrue(generator.isPrime(7901));
    }

    @Test
    public void isPrime_7907() throws Exception {
        assertTrue(generator.isPrime(7907));
    }

    @Test
    public void isPrime_7919() throws Exception {
        assertTrue(generator.isPrime(7919));
    }

    @Test
    public void testRange_1to10() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = generator.generate(1, 10);

        assertNotNull(actual);
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to10Reverse() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = generator.generate(10, 1);

        assertNotNull(actual);
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generator.generate(1, 10);

        assertNotNull(actual);
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920Reverse() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generator.generate(7920, 7900);

        assertNotNull(actual);
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

}