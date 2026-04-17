import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharactersUsingMap {

    public int lengthOfLongestSubstring(String s) {

        // This is an optimized sliding window approach using a HashMap.
        // Instead of removing characters one by one (like in Set approach),
        // I directly jump the left pointer when I find a duplicate.

        // Map will store:
        // key   -> character
        // value -> last index where this character appeared
        Map<Character, Integer> lastSeenIndex = new HashMap<>();

        // 'left' pointer represents the start of the current window
        int left = 0;

        // This will store the maximum length found
        int maxLength = 0;

        // Traverse string using 'right' pointer
        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            // If character was seen before,
            // move 'left' to one position after its last occurrence
            // IMPORTANT: use Math.max to avoid moving left backwards
            if (lastSeenIndex.containsKey(currentChar)) {
                left = Math.max(left, lastSeenIndex.get(currentChar) + 1);
            }

            // Update latest index of current character
            lastSeenIndex.put(currentChar, right);

            // Calculate current window length
            int currentWindowLength = right - left + 1;

            // Update maximum length
            maxLength = Math.max(maxLength, currentWindowLength);
        }

        // Return final answer
        return maxLength;
    }
}