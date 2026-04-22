import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetectionUsingAdditionalMemory {

    public boolean hasCycle(ListNode headNode) {

        // This function checks whether a singly linked list contains a cycle
        // It uses a HashSet to store visited nodes

        // 'visitedNodesSet' stores all nodes we have already seen
        Set<ListNode> visitedNodesSet = new HashSet<>();

        // 'currentNode' is used to traverse the linked list
        ListNode currentNode = headNode;

        // Traverse the list until we reach the end (null)
        while (currentNode != null) {

            // If the node is already in the set, a cycle exists
            if (visitedNodesSet.contains(currentNode)) {
                return true;
            }

            // Otherwise, add the current node to the set
            visitedNodesSet.add(currentNode);

            // Move to the next node
            currentNode = currentNode.nextNode;
        }

        // If we reach null, no cycle exists
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