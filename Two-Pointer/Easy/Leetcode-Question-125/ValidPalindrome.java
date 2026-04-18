public class ValidPalindrome {

    public boolean isPalindrome(String inputString) {

        // This function checks if a string is a palindrome
        // considering only alphanumeric characters and ignoring case

        // 'leftPointer' starts from the beginning of the string
        int leftPointer = 0;

        // 'rightPointer' starts from the end of the string
        int rightPointer = inputString.length() - 1;

        // Continue until both pointers meet
        while (leftPointer < rightPointer) {

            // Move leftPointer forward until it points to an alphanumeric character
            while (leftPointer < rightPointer &&
                   !Character.isLetterOrDigit(inputString.charAt(leftPointer))) {
                leftPointer++;
            }

            // Move rightPointer backward until it points to an alphanumeric character
            while (leftPointer < rightPointer &&
                   !Character.isLetterOrDigit(inputString.charAt(rightPointer))) {
                rightPointer--;
            }

            // Compare characters in lowercase to ignore case differences
            char leftChar = Character.toLowerCase(inputString.charAt(leftPointer));
            char rightChar = Character.toLowerCase(inputString.charAt(rightPointer));

            // If characters do not match, it's not a palindrome
            if (leftChar != rightChar) {
                return false;
            }

            // Move both pointers inward
            leftPointer++;
            rightPointer--;
        }

        // If all characters matched, it's a palindrome
        return true;
    }

}
