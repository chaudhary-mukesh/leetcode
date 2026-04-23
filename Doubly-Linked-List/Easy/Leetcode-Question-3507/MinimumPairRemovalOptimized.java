import java.util.PriorityQueue;

public class MinimumPairRemovalOptimized {

    // Helper class to represent a pair of adjacent indices
    static class Pair {
        int leftIndex;
        int rightIndex;
        int sum;

        Pair(int leftIndex, int rightIndex, int sum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.sum = sum;
        }
    }

    public int getMinimumPairRemovalOperations(int[] inputArray) {

        int n = inputArray.length;

        // Edge case: already sorted
        if (n <= 1) return 0;

        // Doubly linked list using arrays
        int[] values = inputArray.clone();
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] isActive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i == n - 1) ? -1 : i + 1;
            isActive[i] = true;
        }

        // Min-heap based on pair sum
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.sum, b.sum)
        );

        // Initialize heap with all adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            minHeap.offer(new Pair(i, i + 1, values[i] + values[i + 1]));
        }

        int operations = 0;

        while (!isNonDecreasing(values, next, isActive)) {

            Pair currentPair = minHeap.poll();

            int left = currentPair.leftIndex;
            int right = currentPair.rightIndex;

            // Skip if pair is no longer valid
            if (!isActive[left] || !isActive[right] || next[left] != right) {
                continue;
            }

            // Merge the pair
            values[left] = values[left] + values[right];
            isActive[right] = false;

            // Remove right node from list
            next[left] = next[right];
            if (next[right] != -1) {
                prev[next[right]] = left;
            }

            // Add new adjacent pairs involving 'left'
            if (prev[left] != -1) {
                int p = prev[left];
                minHeap.offer(new Pair(p, left, values[p] + values[left]));
            }

            if (next[left] != -1) {
                int nx = next[left];
                minHeap.offer(new Pair(left, nx, values[left] + values[nx]));
            }

            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(int[] values, int[] next, boolean[] isActive) {

        // Traverse active elements only
        int current = -1;

        // Find first active node
        for (int i = 0; i < values.length; i++) {
            if (isActive[i]) {
                current = i;
                break;
            }
        }

        while (current != -1 && next[current] != -1) {
            int nxt = next[current];

            if (values[nxt] < values[current]) {
                return false;
            }

            current = nxt;
        }

        return true;
    }
}