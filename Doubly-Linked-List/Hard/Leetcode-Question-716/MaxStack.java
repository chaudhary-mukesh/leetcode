import java.util.*;

public class MaxStack {

    // Doubly Linked List Node
    class DoublyLinkedNode {
        int value;
        DoublyLinkedNode prev, next;

        DoublyLinkedNode(int value) {
            this.value = value;
        }
    }

    // TreeMap:
    // key   -> value in stack
    // value -> list of nodes having that value
    // Helps us get max element in O(log n)
    private TreeMap<Integer, List<DoublyLinkedNode>> valueToNodesMap;

    // Doubly Linked List pointers (with dummy nodes)
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public MaxStack() {

        valueToNodesMap = new TreeMap<>();

        // Initialize dummy head and tail
        head = new DoublyLinkedNode(0);
        tail = new DoublyLinkedNode(0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node before tail → represents stack push (top)
    private void addNodeToTop(DoublyLinkedNode node) {

        DoublyLinkedNode previousNode = tail.prev;

        previousNode.next = node;
        node.prev = previousNode;

        node.next = tail;
        tail.prev = node;
    }

    // Remove any node from DLL in O(1)
    private void removeNode(DoublyLinkedNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void push(int value) {

        DoublyLinkedNode newNode = new DoublyLinkedNode(value);

        // Add to stack (DLL)
        addNodeToTop(newNode);

        // Add to TreeMap
        valueToNodesMap
                .computeIfAbsent(value, k -> new ArrayList<>())
                .add(newNode);
    }

    public int pop() {

        // Top of stack is just before tail
        DoublyLinkedNode nodeToRemove = tail.prev;

        removeNode(nodeToRemove);

        // Update TreeMap
        List<DoublyLinkedNode> nodesList = valueToNodesMap.get(nodeToRemove.value);
        nodesList.remove(nodesList.size() - 1);

        if (nodesList.isEmpty()) {
            valueToNodesMap.remove(nodeToRemove.value);
        }

        return nodeToRemove.value;
    }

    public int top() {
        return tail.prev.value;
    }

    public int peekMax() {

        // Last key in TreeMap = maximum value
        return valueToNodesMap.lastKey();
    }

    public int popMax() {

        // Get maximum value
        int maxValue = valueToNodesMap.lastKey();

        List<DoublyLinkedNode> nodesList = valueToNodesMap.get(maxValue);

        // Remove the most recently added node with max value
        DoublyLinkedNode nodeToRemove = nodesList.remove(nodesList.size() - 1);

        // Remove from DLL
        removeNode(nodeToRemove);

        if (nodesList.isEmpty()) {
            valueToNodesMap.remove(maxValue);
        }

        return maxValue;
    }
}