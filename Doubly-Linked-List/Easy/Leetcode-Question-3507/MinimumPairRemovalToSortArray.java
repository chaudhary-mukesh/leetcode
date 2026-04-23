import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovalToSortArray {

    public int getMinimumPairRemovalOperations(int[] inputArray) {

        // Convert the input array into a List for easier manipulation (removal and update)
        List<Integer> numbersList = new ArrayList<>();
        for (int number : inputArray) {
            numbersList.add(number);
        }

        // 'operationCount' keeps track of how many merge operations we perform
        int operationCount = 0;

        // Continue operations until the list becomes non-decreasing
        while (!isNonDecreasingOrder(numbersList)) {

            // 'minimumPairSum' stores the smallest sum of adjacent elements
            int minimumPairSum = Integer.MAX_VALUE;

            // 'mergeIndex' stores the index where the minimum sum pair is found
            int mergeIndex = 0;

            // Iterate through adjacent pairs to find the pair with the minimum sum
            for (int i = 0; i < numbersList.size() - 1; i++) {

                int currentPairSum = numbersList.get(i) + numbersList.get(i + 1);

                // Update if we find a smaller sum
                if (currentPairSum < minimumPairSum) {
                    minimumPairSum = currentPairSum;
                    mergeIndex = i;
                }
            }

            // Replace the first element of the pair with their sum
            numbersList.set(mergeIndex, minimumPairSum);

            // Remove the second element of the pair
            numbersList.remove(mergeIndex + 1);

            // Increment the operation counter
            operationCount++;
        }

        // Return the total number of operations required
        return operationCount;
    }

    private boolean isNonDecreasingOrder(List<Integer> numbersList) {

        // This function checks whether the list is in non-decreasing order
        // (Each element should be greater than or equal to the previous one)

        for (int i = 1; i < numbersList.size(); i++) {

            // If a decreasing pair is found, return false
            if (numbersList.get(i) < numbersList.get(i - 1)) {
                return false;
            }
        }

        // If no decreasing pair is found, the list is non-decreasing
        return true;
    }
}