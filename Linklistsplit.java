class listNode {
    int val;
    listNode next;
    listNode(int val) { this.val = val; }
}

class LinkedList {

    public static listNode[] splitListToParts(listNode root, int k) {
        listNode[] parts = new listNode[k];
        int totalLength = 0;
        listNode current = root;

        // Calculate the total length of the linked list
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        int partSize = totalLength / k;
        int extraNodes = totalLength % k;

        current = root;
        for (int i = 0; i < k; i++) {
            listNode head = current;
            for (int j = 0; j < partSize + (i < extraNodes ? 1 : 0) - 1; j++) {
                if (current != null) current = current.next;
            }

            if (current != null) {
                listNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
            parts[i] = head;
        }

        return parts;
    }

    public static void main(String[] args) {
        // Example usage
        listNode root = new listNode(1);
        root.next = new listNode(2);
        root.next.next = new listNode(3);
        root.next.next.next = new listNode(4);
        root.next.next.next.next = new listNode(5);


        int k = 2;  // User-specified number of parts
        listNode[] parts = splitListToParts(root, k);

        // Print the parts
        for (int i = 0; i < parts.length; i++) {
            listNode current = parts[i];
            System.out.print("Part " + (i + 1) + ": ");
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

