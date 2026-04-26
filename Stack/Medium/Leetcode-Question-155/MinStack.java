public class MinStack {

    // Top of the stack (linked list head)
    private StackNode topNode;

    // Constructor initializes an empty stack
    public MinStack() {
    }

    // Push a value onto the stack
    public void push(int value) {

        // If stack is empty, the min is the value itself
        if (topNode == null) {
            topNode = new StackNode(value, value, null);
        } else {
            // Store the minimum value up to this node
            int currentMin = Math.min(value, topNode.minValue);
            topNode = new StackNode(value, currentMin, topNode);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (topNode != null) {
            topNode = topNode.nextNode;
        }
    }

    // Get the top element of the stack
    public int top() {
        return topNode.value;
    }

    // Retrieve the minimum element in constant time
    public int getMin() {
        return topNode.minValue;
    }

    // Inner class representing each node in the stack
    private class StackNode {

        int value;        // Actual value stored
        int minValue;     // Minimum value up to this node
        StackNode nextNode; // Reference to next node

        StackNode(int value, int minValue, StackNode nextNode) {
            this.value = value;
            this.minValue = minValue;
            this.nextNode = nextNode;
        }
    }
}