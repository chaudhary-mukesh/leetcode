import java.util.Stack;

public class DailyTemperaturesUsingMonotonicStack {

    public int[] getDaysUntilWarmerTemperature(int[] temperatures) {

        int totalDays = temperatures.length;

        // This array will store the result:
        // ans[i] = number of days to wait for a warmer temperature
        int[] daysToWait = new int[totalDays];

        // Stack will store indices of days
        // It will maintain a decreasing temperature order (monotonic stack)
        Stack<Integer> indexStack = new Stack<>();

        // Traverse all days
        for (int currentDay = 0; currentDay < totalDays; currentDay++) {

            // While current temperature is higher than the temperature
            // at index stored on top of stack
            while (!indexStack.isEmpty() &&
                   temperatures[currentDay] > temperatures[indexStack.peek()]) {

                // Get the previous day's index
                int previousDayIndex = indexStack.pop();

                // Calculate how many days it took to get a warmer temperature
                daysToWait[previousDayIndex] = currentDay - previousDayIndex;
            }

            // Push current day index onto stack
            indexStack.push(currentDay);
        }

        // Remaining indices in stack have no warmer future day,
        // so their values remain 0 (default)

        return daysToWait;
    }
}