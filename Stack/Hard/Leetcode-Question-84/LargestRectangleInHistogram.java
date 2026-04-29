import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] barHeights) {

        int maxArea = 0;

        // Stack will store indices of bars
        // It maintains increasing order of heights
        Stack<Integer> indexStack = new Stack<>();

        int totalBars = barHeights.length;

        // Traverse all bars + one extra iteration (to empty stack)
        for (int i = 0; i <= totalBars; i++) {

            // For last iteration, treat height as 0 to flush stack
            int currentHeight = (i == totalBars) ? 0 : barHeights[i];

            // While current bar is smaller than stack top → process area
            while (!indexStack.isEmpty() &&
                    currentHeight < barHeights[indexStack.peek()]) {

                // Height of rectangle
                int height = barHeights[indexStack.pop()];

                // Calculate width:
                // If stack is empty → width = i
                // Else → width = i - previous index - 1
                int width = indexStack.isEmpty()
                        ? i
                        : i - indexStack.peek() - 1;

                // Calculate area and update max
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index to stack
            indexStack.push(i);
        }

        return maxArea;
    }
}