package LinkedQueue;

public class LinkedQueueMain {
    public static void main(String[] args) {
        LinkedQueue list = new LinkedQueue();
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
           list.add(200);
        }
        System.out.println("Queue size: " + list.size());
        System.out.println("First element: " + list.first());
        //IMPLEMENTS REMOVE
       while (list.size() > 0) {
            System.out.println("Removed element: " + list.remove());
        }
    }
}
