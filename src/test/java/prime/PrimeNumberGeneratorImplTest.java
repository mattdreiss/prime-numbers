package prime;

import com.google.common.collect.Ordering;
import org.junit.Before;
import org.junit.Ignore;
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
        generator = new SieveOfEratosthenesGenerator();
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
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to10Reverse() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        List<Integer> actual = generator.generate(10, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to1000() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        List<Integer> actual = generator.generate(1, 1000);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_1to1000Reverse() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        List<Integer> actual = generator.generate(1000, 1);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generator.generate(7900, 7920);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

    @Test
    public void testRange_7900to7920Reverse() {
        List<Integer> expected = Arrays.asList(7901, 7907, 7919);
        List<Integer> actual = generator.generate(7920, 7900);

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(Ordering.natural().isOrdered(actual));
    }

}