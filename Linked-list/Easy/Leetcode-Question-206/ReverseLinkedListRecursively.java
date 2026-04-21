class ListNode {
    int value;
    ListNode nextNode;

    ListNode() {}

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
}

public class ReverseLinkedListRecursively {

    public ListNode reverseLinkedList(ListNode headNode) {

        // This function reverses a singly linked list using recursion

        // Base case:
        // If list is empty OR only one node exists, return it as-is
        if (headNode == null || headNode.nextNode == null) {
            return headNode;
        }

        // Recursively reverse the rest of the list starting from next node
        ListNode newHeadNode = reverseLinkedList(headNode.nextNode);

        // Fix the current node:
        // Make next node point back to current node
        headNode.nextNode.nextNode = headNode;

        // Set current node's next to null to avoid cycle
        headNode.nextNode = null;

        // Return new head of reversed list
        return newHeadNode;
    }
}