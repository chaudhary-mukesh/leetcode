import java.util.HashMap;
import java.util.Map;

class MinimumDistanceBetweenMirrorNumbers {

    public int minMirrorPairDistance(int[] nums) {

        // I want to find the minimum distance between two indices i and j
        // such that nums[i] is the reverse of nums[j].
        // Example: 12 and 21 are mirror pairs.

        int n = nums.length;

        // Initialize answer with a large value
        // If it remains unchanged, it means no valid pair exists
        int minDistance = n + 1;

        // This map will store:
        // key   -> reversed number
        // value -> index where this reversed number should match
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < n; i++) {

            int current = nums[i];

            // If current number already exists in map,
            // it means we previously saw its mirror pair
            if (map.containsKey(current)) {

                // Compute distance between indices
                int prevIndex = map.get(current);
                minDistance = Math.min(minDistance, i - prevIndex);
            }

            // Store the reversed version of current number
            // so future elements can match with it
            int reversed = reverseNumber(current);
            map.put(reversed, i);
        }

        // If no valid pair found, return -1
        return (minDistance == n + 1) ? -1 : minDistance;
    }

    private int reverseNumber(int num) {

        // This function reverses digits of a number
        // Example: 123 -> 321

        int reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }

        return reversed;
    }
}