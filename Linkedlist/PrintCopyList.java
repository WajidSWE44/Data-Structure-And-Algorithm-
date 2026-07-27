package Linkedlist;

public class PrintCopyList {



    public static void main(String[] args) {
        // Create the original linked list
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);

        // Print the original list
        System.out.println("Original list:");
        Node.printList(start);

        // Create a copy of the list
        Node copiedList = start.copy(start);

        // Print the copied list
        System.out.println("Copied list:");
        Node.printList(copiedList);
    }
}