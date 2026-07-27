package LinkedListHalf;

class Node {
    Node next;
    int data;
}
class Linked {
    Node first, second;
    public void alternateSplit(Node node) {
        if(node == null || node.next == null) {
            return;
        }
        Node firstTemp;
        Node secondTemp;

        first = firstTemp = node;
        second = secondTemp = node.next;
        node = node.next.next;

        while(node!= null && node.next != null) {
            firstTemp.next = node;
            secondTemp.next = node.next;

            firstTemp = firstTemp.next;
            secondTemp = secondTemp.next;

            node = node.next.next;
        }
        if(node != null) {
            firstTemp.next = node;
            firstTemp = firstTemp.next;
        }
        firstTemp.next = null;
        secondTemp.next = null;
        return;
    }
    // getNewNode() method to generate a new node
    public Node getNewNode(int key) {
        Node a = new Node();
        a.next = null;
        a.data = key;
        return a;
    }
    // insert method is used to insert the element in Linked List
    public Node insert(int key, Node node) {
        if (node == null)
            return getNewNode(key);
        else
            node.next = insert(key, node.next);
        return node;
    }
    // It'll print the complete linked list
    public void printList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printList(node.next);
    }
}
public class LinkedListHalf {
    public static void main(String[] args) {
        Node start = null;
        Linked a = new Linked();
        start = a.insert(11, start);
        start = a.insert(22, start);
        start = a.insert(33, start);
        start = a.insert(44, start);
        start = a.insert(55, start);
        start = a.insert(66, start);
        start = a.insert(77, start);

        a.printList(start);
        System.out.println();

        a.alternateSplit(start);

        a.printList(a.first);
        System.out.println();

        a.printList(a.second);
    }
}

