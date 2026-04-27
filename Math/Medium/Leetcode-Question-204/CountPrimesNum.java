import java.util.Arrays;

public class CountPrimesNum {

    public int countPrimes(int limit) {

        // This function counts how many prime numbers are less than 'limit'
        // We use the Sieve of Eratosthenes algorithm

        // If limit is less than 2, there are no prime numbers
        if (limit < 2) return 0;

        // Create a boolean array to track prime numbers
        // Assume all numbers are prime initially
        boolean[] isPrimeArray = new boolean[limit];
        Arrays.fill(isPrimeArray, true);

        // 0 and 1 are not prime numbers
        isPrimeArray[0] = false;
        isPrimeArray[1] = false;

        // Start marking non-prime numbers
        // We only need to go up to sqrt(limit)
        for (int currentNumber = 2; currentNumber * currentNumber < limit; currentNumber++) {

            // If the current number is still marked as prime
            if (isPrimeArray[currentNumber]) {

                // Mark all multiples of currentNumber as non-prime
                // Start from currentNumber * currentNumber
                for (int multiple = currentNumber * currentNumber; multiple < limit; multiple += currentNumber) {
                    isPrimeArray[multiple] = false;
                }
            }
        }

        // Count how many numbers are still marked as prime
        int primeCount = 0;
        for (int number = 2; number < limit; number++) {
            if (isPrimeArray[number])
                primeCount++;
        }

        // Return the total count of prime numbers
        return primeCount;
    }
}
