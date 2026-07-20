package Algorithm;

class ItemNode {
    int itemCode;
    String itemName;
    ItemNode next;

    public ItemNode(int itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.next = null;
    }
}

class ItemLinkedList {
    private ItemNode head;

    public void addItem(int itemCode, String itemName) {
        ItemNode newItem = new ItemNode(itemCode, itemName);
        newItem.next = head;
        head = newItem;
    }

    public String getItemName(int itemCode) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemCode == itemCode) {
                return current.itemName;
            }
            current = current.next;
        }
        return null;
    }
}

