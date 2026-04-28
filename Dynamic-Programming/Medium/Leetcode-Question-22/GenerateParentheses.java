import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int numberOfPairs) {

        // This list will store all valid combinations
        List<String> result = new ArrayList<>();

        // Start backtracking with:
        // empty string, 0 open brackets, 0 close brackets
        generateCombinations(result, new StringBuilder(), 0, 0, numberOfPairs);

        return result;
    }

    private void generateCombinations(List<String> result,
                                      StringBuilder currentString,
                                      int openCount,
                                      int closeCount,
                                      int maxPairs) {

        // Base Case:
        // If the current string length reaches 2 * maxPairs,
        // it means we formed a valid parentheses combination
        if (currentString.length() == maxPairs * 2) {
            result.add(currentString.toString());
            return;
        }

        // Step 1: Add an opening bracket "("
        // Only if we still have remaining open brackets to use
        if (openCount < maxPairs) {
            currentString.append("(");

            // Recurse with one more open bracket used
            generateCombinations(result, currentString, openCount + 1, closeCount, maxPairs);

            // Backtrack: remove last character
            currentString.deleteCharAt(currentString.length() - 1);
        }

        // Step 2: Add a closing bracket ")"
        // Only if closing brackets are less than opening brackets
        // (to maintain valid parentheses)
        if (closeCount < openCount) {
            currentString.append(")");

            // Recurse with one more close bracket used
            generateCombinations(result, currentString, openCount, closeCount + 1, maxPairs);

            // Backtrack: remove last character
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}