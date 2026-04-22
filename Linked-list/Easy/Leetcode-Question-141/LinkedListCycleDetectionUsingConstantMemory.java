public class LinkedListCycleDetectionUsingConstantMemory {

    public boolean hasCycle(ListNode headNode) {

        // This function checks whether a singly linked list contains a cycle
        // It uses Floyd’s Cycle Detection (slow and fast pointer approach)

        // 'slowPointer' moves one step at a time
        ListNode slowPointer = headNode;

        // 'fastPointer' moves two steps at a time
        ListNode fastPointer = headNode;

        // Traverse the list while ensuring fastPointer can move ahead
        while (fastPointer != null && fastPointer.nextNode != null) {

            // Move pointers
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            // If both pointers meet, a cycle exists
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        // If fastPointer reaches null, no cycle exists
        return false;
    }
}

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