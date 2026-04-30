import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String inputString) {

        // This will store the starting index of the last invalid ')'
        int lastInvalidIndex = -1;

        // Stores the maximum length of valid parentheses substring
        int maxLength = 0;

        // Stack stores indices of '('
        Stack<Integer> openBracketStack = new Stack<>();

        // Traverse the string
        for (int i = 0; i < inputString.length(); i++) {

            char currentChar = inputString.charAt(i);

            if (currentChar == '(') {
                // Push index of opening bracket
                openBracketStack.push(i);

            } else {
                // Encountered closing bracket ')'

                if (!openBracketStack.isEmpty()) {

                    // Found a matching '(' → pop it
                    openBracketStack.pop();

                    if (openBracketStack.isEmpty()) {
                        // No unmatched '(' left → valid substring starts after last invalid index
                        maxLength = Math.max(maxLength, i - lastInvalidIndex);
                    } else {
                        // Valid substring starts after the last unmatched '('
                        maxLength = Math.max(maxLength, i - openBracketStack.peek());
                    }

                } else {
                    // No matching '(' → mark this index as invalid starting point
                    lastInvalidIndex = i;
                }
            }
        }

        return maxLength;
    }
}