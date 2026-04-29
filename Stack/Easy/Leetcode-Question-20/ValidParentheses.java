import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String inputString) {

        // Stack to store opening brackets
        Stack<Character> bracketStack = new Stack<>();

        // Map to store matching pairs:
        // key   -> closing bracket
        // value -> corresponding opening bracket
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        // Traverse each character in the string
        for (char currentChar : inputString.toCharArray()) {

            // If it is a closing bracket
            if (bracketMap.containsKey(currentChar)) {

                // Check if stack is empty OR top doesn't match
                if (bracketStack.isEmpty() ||
                        bracketStack.peek() != bracketMap.get(currentChar)) {
                    return false;
                }

                // Valid match → remove the opening bracket
                bracketStack.pop();

            } else {
                // If it's an opening bracket → push to stack
                bracketStack.push(currentChar);
            }
        }

        // If stack is empty → all brackets matched correctly
        return bracketStack.isEmpty();
    }
}