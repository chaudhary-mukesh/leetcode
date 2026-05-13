public class MinimumMovesToMakeArrayComplementary {

    public int minMoves(int[] inputArray, int limit) {

        int arrayLength = inputArray.length;

        // Difference array to track changes in operations
        int[] differenceArray = new int[2 * limit + 2];

        // Step 1: Process pairs (i, n - 1 - i)
        for (int i = 0; i < arrayLength / 2; i++) {

            int leftValue = inputArray[i];
            int rightValue = inputArray[arrayLength - 1 - i];

            int smaller = Math.min(leftValue, rightValue);
            int larger = Math.max(leftValue, rightValue);

            // Base case: assume 2 moves for all sums
            differenceArray[2] += 2;

            // Case 1: Reduce to 1 move (range: smaller + 1 to larger + limit)
            differenceArray[smaller + 1] -= 1;

            // Case 2: Reduce to 0 move (exact sum = smaller + larger)
            differenceArray[smaller + larger] -= 1;
            differenceArray[smaller + larger + 1] += 1;

            // Case 3: Back to 2 moves after larger + limit
            differenceArray[larger + limit + 1] += 1;
        }

        int minimumOperations = arrayLength;
        int currentOperations = 0;

        // Step 2: Calculate prefix sum to get operations for each possible sum
        for (int targetSum = 2; targetSum <= 2 * limit; targetSum++) {

            currentOperations += differenceArray[targetSum];

            // Track minimum operations required
            minimumOperations = Math.min(minimumOperations, currentOperations);
        }

        return minimumOperations;
    }
}