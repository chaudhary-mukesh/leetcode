import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharactersUsingHashSet {

    public int lengthOfLongestSubstring(String s) {

        // This is a classic sliding window problem.
        // I need to find the longest substring with all unique characters.

        // I'll use a HashSet to maintain the current window of unique characters
        Set<Character> window = new HashSet<>();

        // 'left' pointer represents the start of the window
        int left = 0;

        // This will store the maximum length found
        int maxLength = 0;

        // Traverse the string using 'right' pointer
        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            // If current character already exists in the window,
            // shrink the window from the left until it's removed
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Now it's safe to add current character
            window.add(currentChar);

            // Update maximum length of valid window
            int currentWindowLength = right - left + 1;
            maxLength = Math.max(maxLength, currentWindowLength);
        }

        // Return the result
        return maxLength;
    }
}