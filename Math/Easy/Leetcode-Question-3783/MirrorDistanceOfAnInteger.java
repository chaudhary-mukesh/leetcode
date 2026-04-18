public class MirrorDistanceOfAnInteger {

    public int mirrorDistance(int number) {

        // This function calculates the absolute difference
        // between a number and its reversed version

        // Get the reversed number
        int reversedNumber = reverseNumber(number);

        // Calculate and return the absolute difference
        return Math.abs(number - reversedNumber);
    }

    private int reverseNumber(int originalNumber) {

        // This will store the reversed value
        int reversedValue = 0;

        // Continue until all digits are processed
        while (originalNumber > 0) {

            // Extract the last digit
            int lastDigit = originalNumber % 10;

            // Append the digit to the reversed value
            reversedValue = reversedValue * 10 + lastDigit;

            // Remove the last digit from original number
            originalNumber = originalNumber / 10;
        }

        // Return the reversed number
        return reversedValue;
    }
}
