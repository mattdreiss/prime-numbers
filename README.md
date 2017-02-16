# Prime Number Generation

Compares two methods of generating ranges of prime numbers. The first method uses division to determine if an integer
is prime or not and the second method implements the Sieve of Eratosthenes. The performance tests demonstrate the
strengths and the weaknesses of each method.

## Running

The application uses Gradle as the build tool. If gradle is not installed, follow the instructions here 
<a href="https://gradle.org/install">https://gradle.org/install</a>

To build and unit test the application run the command `gradle build`

After the application has built, the executable jar can be run with a range provided via the command line arguments.
The jar is located at `build/libs/prime-numbers.jar`.

Example Usage: `java -jar build/libs/prime-numbers.jar 1 100`

## Tests

There are two test suites included. The first suite tests the proper execution of the two
algorithms and is executed during the build of the application. The second suite are performance
tests. These tests compare the execution time of the algorithms and are fairly long running.
In my testing they would finish in under two minutes. To run the performance tests

`gradle clean perfTest`

## Instructions

Your task is to use test driven development to implement a prime number generator that
returns an ordered list of all prime numbers in a given range (inclusive of the endpoints).
You must implement the interface specified below. You may also create any other
methods, interfaces and/or classes that you deem necessary to complete the project.
You should also develop a small main program to drive your generator and to allow the
user to specify the prime number range via the command line. To successfully
complete the exercise, all unit tests must pass as well as provide 100% code coverage.
Notes:
<ul>
<li>The code should handle inverse ranges such that 1-10 and 10-1 are equivalent.</li>
<li>Ensure that you run a test against the range 7900 and 7920 (valid primes are 7901,
7907, 7919).</li>
</ul>

```
Interface PrimeNumberGenerator {
List<Integer> generate(int startingValue, int endingValue);
boolean isPrime(int value);
}
