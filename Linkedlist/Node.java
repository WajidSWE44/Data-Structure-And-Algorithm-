package Linkedlist;

public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }


public Node copy(Node p) {
    if (p == null) {
        return null;  // Handle the case for an empty list
    }

    // Create a new head for the copied list
    Node q = new Node(p.data);
    Node temp = q;
    p = p.next;

    // Copy the rest of the nodes
    while (p != null) {
        temp.next = new Node(p.data);  // Create a new node and link it
        temp = temp.next;              // Move to the next node
        p = p.next;                    // Move to the next node in the original list
    }
    return q;  // Return the head of the copied list
}

    // Method to print the linked list
    public static void printList(Node start) {
        Node current = start;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
