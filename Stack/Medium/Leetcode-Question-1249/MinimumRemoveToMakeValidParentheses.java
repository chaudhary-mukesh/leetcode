import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String inputString) {

        // This set will store indices of characters to be removed
        Set<Integer> indicesToRemove = new HashSet<>();

        // Stack will store indices of unmatched '('
        Stack<Integer> openBracketStack = new Stack<>();

        // Step 1: Traverse the string to identify invalid parentheses
        for (int i = 0; i < inputString.length(); i++) {

            char currentChar = inputString.charAt(i);

            if (currentChar == '(') {
                // Store index of opening bracket
                openBracketStack.push(i);

            } else if (currentChar == ')') {

                if (openBracketStack.isEmpty()) {
                    // No matching '(' → mark this ')' for removal
                    indicesToRemove.add(i);
                } else {
                    // Found a matching pair → pop the '(' index
                    openBracketStack.pop();
                }
            }
        }

        // Step 2: Any remaining '(' in stack are unmatched → remove them
        while (!openBracketStack.isEmpty()) {
            indicesToRemove.add(openBracketStack.pop());
        }

        // Step 3: Build the final valid string
        StringBuilder validString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            // Append only characters not marked for removal
            if (!indicesToRemove.contains(i)) {
                validString.append(inputString.charAt(i));
            }
        }

        return validString.toString();
    }
}