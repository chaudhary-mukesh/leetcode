class ContainerWithMostWater {

    public int maxArea(int[] heights) {

        // This is a two-pointer problem.
        // I need to find the maximum water that can be contained between two lines.

        // 'leftPointer' starts from the beginning
        int leftPointer = 0;

        // 'rightPointer' starts from the end
        int rightPointer = heights.length - 1;

        // This will store the maximum water found
        int maxWater = 0;

        // Continue until both pointers meet
        while (leftPointer < rightPointer) {

            // Find the smaller height between the two pointers
            int minHeight = Math.min(heights[leftPointer], heights[rightPointer]);

            // Calculate the width between pointers
            int width = rightPointer - leftPointer;

            // Calculate current water area
            int currentWater = width * minHeight;

            // Update maximum water if current is greater
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer pointing to the smaller height
            // because moving the taller one won't increase area
            if (heights[leftPointer] > heights[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        // Return the maximum water found
        return maxWater;
    }
}