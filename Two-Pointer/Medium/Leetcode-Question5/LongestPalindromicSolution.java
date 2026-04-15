class LongestPalindromicSolution {
    public String longestPalindrome(String s) {
        // First, I check edge cases — if string is null or empty,
        // there’s no valid palindrome to return
        if(s == null || s.length() < 1) return "";

        // I’ll track the best (longest) palindrome using start and end indices
        int start = 0;
        int end = 0;

        // Instead of checking all substrings (which would be too slow),
        // I’m thinking: a palindrome always expands from its center.
        // So for every index, I’ll try to expand outward.

        for(int i = 0; i < s.length(); i++) {

            // First, I assume current index is the center of an odd-length palindrome
            int len1 = expandFromCenter(s, i, i);

            // Then, I also check for even-length palindrome
            // where center is between i and i+1
            int len2 = expandFromCenter(s, i, i + 1);

            // I take whichever gives me the longer palindrome
            int len = Math.max(len1, len2);

            // If this palindrome is longer than what I’ve seen so far,
            // I update my start and end pointers
            if (len > end - start) {

                // I calculate new start and end based on the center and length
                // This formula works for both odd and even cases
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Finally, I return the substring using the best indices I found
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        // Here, I keep expanding outward as long as:
        // 1. I stay within bounds
        // 2. Characters on both sides match
        while (left >= 0 && right < s.length() 
               && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // When the loop stops, I’ve gone one step too far,
        // so I subtract 1 from both sides to get the correct length
        return right - left - 1;
    }
}