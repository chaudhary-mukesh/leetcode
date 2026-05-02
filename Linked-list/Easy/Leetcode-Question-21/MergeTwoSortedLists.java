class ListNode {
    int value;
    ListNode next;

    ListNode() {}

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode firstList, ListNode secondList) {

        // Dummy node helps simplify edge cases
        ListNode dummyNode = new ListNode(0);

        // Pointer to build the merged list
        ListNode current = dummyNode;

        // Step 1: Traverse both lists until one becomes null
        while (firstList != null && secondList != null) {

            // Compare values and attach the smaller node
            if (firstList.value <= secondList.value) {
                current.next = firstList;
                firstList = firstList.next;
            } else {
                current.next = secondList;
                secondList = secondList.next;
            }

            // Move forward in the merged list
            current = current.next;
        }

        // Step 2: Attach remaining nodes (if any)
        // Only one of them will be non-null
        current.next = (firstList != null) ? firstList : secondList;

        // Return merged list (skip dummy node)
        return dummyNode.next;
    }
}