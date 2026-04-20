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

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode firstList, ListNode secondList) {

        // This function adds two numbers represented as linked lists
        // Each node contains a single digit, and digits are stored in reverse order

        // Dummy node to simplify result list creation
        ListNode dummyHead = new ListNode(0);

        // Pointer to build the result list
        ListNode currentNode = dummyHead;

        // Variable to store carry from previous addition
        int carryValue = 0;

        // Traverse both lists until all digits and carry are processed
        while (firstList != null || secondList != null || carryValue != 0) {

            // Start with carry from previous step
            int currentSum = carryValue;

            // Add value from first list if available
            if (firstList != null) {
                currentSum += firstList.value;
                firstList = firstList.nextNode;
            }

            // Add value from second list if available
            if (secondList != null) {
                currentSum += secondList.value;
                secondList = secondList.nextNode;
            }

            // Update carry for next iteration
            carryValue = currentSum / 10;

            // Create a new node with the digit part of the sum
            currentNode.nextNode = new ListNode(currentSum % 10);

            // Move to the next node in the result list
            currentNode = currentNode.nextNode;
        }

        // Return the result list (skip dummy head)
        return dummyHead.nextNode;
    }
}