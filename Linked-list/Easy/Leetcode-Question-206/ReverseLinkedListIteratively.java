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

public class ReverseLinkedListIteratively {

    public ListNode reverseLinkedList(ListNode headNode) {

        // This function reverses a singly linked list using iteration

        // 'previousNode' will become the new head of the reversed list
        ListNode previousNode = null;

        // 'currentNode' is used to traverse the original list
        ListNode currentNode = headNode;

        // Traverse the list until all nodes are reversed
        while (currentNode != null) {

            // Store the next node before breaking the link
            ListNode nextTempNode = currentNode.nextNode;

            // Reverse the current node's pointer
            currentNode.nextNode = previousNode;

            // Move 'previousNode' one step forward
            previousNode = currentNode;

            // Move 'currentNode' one step forward
            currentNode = nextTempNode;
        }

        // 'previousNode' will be the new head after full reversal
        return previousNode;
    }
}