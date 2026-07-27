package LinkedQueue;

public class LinkedQueue implements Queue {
private static class Node{
    Object object;
    Node prev = this,next = this;
    Node(Object object){
        this.object=object;
    }
    Node(Object object, Node next, Node prev){
        this.object =object;
        this.next =next;
        this.prev =prev;
    }
}
    private int size;
    private Node head = new Node(null);
    private int sum = 0;
    @Override
    public void add(Object object) {
    head.prev.next = new Node(object,head.prev,head);
    head.prev = head.prev.next;
    ++size;
    }
   /* public void add(Object object) {
        if (!(object instanceof Integer)) {
            throw new IllegalArgumentException("Only integers are allowed");
        }
        Integer value = (Integer) object;

        // Update the sum
        sum += value;

        // Add the element to the queue
        head.prev.next = new Node(value, head, head.prev);
        head.prev = head.prev.next;
        ++size;
    }*/

    @Override
    public Object first() {
       if(size==0)throw new IllegalStateException("LinkedQueue.Queue is Empty");
       return head.next.object;
    }

    @Override
    public Object remove() {
        if(size==0)throw new IllegalStateException("LinkedQueue.Queue is Empty");

        Object temp = head.next.object;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
    //    sum -= temp;

        return temp;
    }

    @Override
    public int size() {
        return size;
    }
}
