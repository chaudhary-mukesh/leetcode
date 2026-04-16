import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class ClosestEqualElementQueriesCircular {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        // First, I note that this is a circular array problem.
        // That means index 0 and index n-1 are considered adjacent.
        // So I need to handle wrap-around distances carefully.

        int n = nums.length;

        // I’ll group all indices of the same value together.
        // Why? Because for any query, I only care about positions
        // where the same number appears.
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Build the map: value -> list of indices
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Now comes the important circular trick:
        // For each list of indices, I simulate circular behavior
        // by adding "virtual" indices at both ends.
        for(ArrayList<Integer> val : map.values()) {

            // First element in original list
            int first = val.get(0);

            // Last element in original list
            int last = val.get(val.size() - 1);

            // To simulate circular wrap:
            // - Add (last - n) at the beginning → represents wrapping left
            // - Add (first + n) at the end → represents wrapping right
            val.add(0, last - n);
            val.add(first + n);
        }

        // This will store answers for each query
        List<Integer> result = new ArrayList<>();

        // Now I process each query
        for (int q : queries) {

            // Value at queried index
            int value = nums[q];

            // Get all positions where this value occurs
            ArrayList<Integer> list = map.get(value);

            // If size == 3, it means:
            // only one real occurrence existed originally,
            // plus the 2 artificial circular entries.
            // So no other equal element exists → answer = -1
            if (list.size() == 3) {
                result.add(-1);
                continue;
            }

            // Now I need to find where index q sits in this list.
            // Since list is sorted, I use binary search.
            int idx = Collections.binarySearch(list, q);

            // If exact index not found (rare but safe to handle),
            // convert to insertion point
            if (idx < 0) idx = -idx - 1;

            // Now the closest equal element must be either:
            // - the next occurrence (right side)
            // - the previous occurrence (left side)

            int rightDist = list.get(idx + 1) - list.get(idx);
            int leftDist  = list.get(idx) - list.get(idx - 1);

            // Take minimum of both directions 
            int dist = Math.min(rightDist, leftDist);

            result.add(dist);
        }

        // Return final answers
        return result;
    }
}