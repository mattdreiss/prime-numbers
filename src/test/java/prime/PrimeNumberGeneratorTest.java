package prime;

import com.google.common.collect.Ordering;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mrd on 2/13/17.
 */
public class PrimeNumberGeneratorTest {

    private PrimeNumberGenerator generatorA;

    private PrimeNumberGenerator generatorB;

    @Before
    public void setup() {
        generatorA = new DivisionPrimeNumberGenerator();
        generatorB = new SieveOfEratosthenesGenerator();
    }

    @Test
    public void isPrime_negative1() throws Exception {
        assertFalse(generatorA.isPrime(-1));
        assertFalse(generatorB.isPrime(-1));
    }

    @Test
    public void isPrime_0() throws Exception {
        assertFalse(generatorA.isPrime(0));
        assertFalse(generatorB.isPrime(0));
    }

    @Test
    public void isPrime_1() throws Exception {
        assertFalse(generatorA.isPrime(1));
        assertFalse(generatorB.isPrime(1));
    }

    @Test
    public void isPrime_2() throws Exception {
        assertTrue(generatorA.isPrime(2));
        assertTrue(generatorB.isPrime(2));
    }

    @Test
    public void isPrime_3() throws Exception {
        assertTrue(generatorA.isPrime(3));
        assertTrue(generatorB.isPrime(3));
    }

    @Test
    public void isPrime_4() throws Exception {
        assertFalse(generatorA.isPrime(4));
        assertFalse(generatorB.isPrime(4));
    }

    @Test
    public void isPrime_5() throws Exception {
        assertTrue(generatorA.isPrime(5));
        assertTrue(generatorB.isPrime(5));
    }

    @Test
    public void isPrime_9() throws Exception {
        assertFalse(generatorA.isPrime(9));
        assertFalse(generatorB.isPrime(9));
    }

    @Test
    public void isPrime_7901() throws Exception {
        assertTrue(generatorA.isPrime(7901));
        assertTrue(generatorB.isPrime(7901));
    }

    @Test
    public void isPrime_7907() throws Exception {
        assertTrue(generatorA.isPrime(7907));
        assertTrue(generatorB.isPrime(7907));
    }

    @Test
    public void isPrime_7919() throws Exception {
        assertTrue(generatorA.isPrime(7919));
        assertTrue(generatorB.isPrime(7919));
    }

    @Test
    public void testRange_negativeRange() {
        List<Integer> actual = generatorA.generate(-10, -1);

        assertNotNull(actual);
        assertEquals(Collections.EMPTY_LIST, actual);

        actual = generatorB.generate(-10, -1);

        assertNotNull(actual);
        assertEquals(Collections.EMPTY_LIST, actual);
    }

    @Test
    public void testRange_smallRange() {
        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> actual = generatorA.generate(1, 3);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(1, 3);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_sameNumberRange() {
        List<Integer> expected = Arrays.asList(2);
        List<Integer> actual = generatorA.generate(2, 2);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(2, 2);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to10() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = generatorA.generate(1, 10);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(1, 10);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to10Reverse() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = generatorA.generate(10, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(10, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to1000() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        List<Integer> actual = generatorA.generate(1, 1000);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(1, 1000);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to1000Reverse() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        List<Integer> actual = generatorA.generate(1000, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(1000, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generatorA.generate(7900, 7920);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(7900, 7920);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920Reverse() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generatorA.generate(7920, 7900);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));

        actual = generatorB.generate(7920, 7900);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

}