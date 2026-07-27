package MergeSortedLists;

class Node {
    int val;
    Node next;
    int data;


    Node(int data) {
        this.data = data;
        this.next = null;  // Always initialize next to null
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;

    }
}
public class MergeSortedLists {
    public static Node mergeTwoLists(Node l1, Node l2) {

        // Create a dummy node to help with the merge process
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and compare nodes
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If there are remaining nodes in either list, attach them
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list starting from the next node of dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        Node l1 = new Node(0);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(6);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(5);
        Node mergedList = mergeTwoLists(l1, l2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }
}


