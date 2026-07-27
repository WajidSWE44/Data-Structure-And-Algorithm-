package Linkedlist;

public class Runner {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.insert(4);
        list.insert(5);
        list.insert(7);
        list.insertatStart(3);
        list.deleteAt(1);
        list.insertAt(2,6);

        list.show();
    }

}
