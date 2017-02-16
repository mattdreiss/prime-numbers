import prime.PrimeNumberGenerator;
import prime.SieveOfEratosthenesGenerator;

import java.util.List;

/**
 * Created by mrd on 2/16/17.
 */
public class Application {

    public static void main(String[] args) {
        int startingValue, endingValue;
        try {
            startingValue = Integer.parseInt(args[0]);
            endingValue = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            displayHelp();
            return;
        }

        PrimeNumberGenerator generator = new SieveOfEratosthenesGenerator();
        List<Integer> primes = generator.generate(startingValue, endingValue);

        for (int i = 0; i < primes.size(); i++) {
            if (i == primes.size() - 1) {
                System.out.println(primes.get(i));
            } else {
                System.out.print(String.format("%s, ", primes.get(i)));
            }
        }

    }

    private static void displayHelp() {
        System.out.println("Usage: prime-numbers <range-start> <range-end> where <range-start> and <range-end> are integers");
    }

}
