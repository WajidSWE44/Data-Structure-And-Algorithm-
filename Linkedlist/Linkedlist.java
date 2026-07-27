package Linkedlist;

public class Linkedlist {
    Node head;


//INSERT NODE AT END
    public void insert(int data){
        Node node = new Node(0);
        node.data =data;
        node.next=null;

        if(head == null){
            head = node;
        }
        else{
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }

    //INSERT NODE AT START
    public void insertatStart(int data){
        Node node = new Node(0);
        node.data =data;
        node.next = null;
        node.next = head;
        head = node;

    }
    //INSERT NODE AT ANYPOSITION
    public void insertAt(int index,int data) {
        Node node = new Node(0);
        node.data = data;
        node.next = null;

        if (index == 0) {
            insertatStart(data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index){
        if(index==0){
            head=head.next;
        }
        else{
            Node n= head;
            Node n1=null;

            for(int i=0;i<index-1;i++){
                n=n.next;
            }
            n1=n.next;
            n.next=n1.next;
            System.out.println("n1 ="+ n1.data);
        }
    }

    //SHOW METHOD
    public void show(){
        Node node= head;
        while (node.next!=null){
            System.out.print(node.data+"-> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
    /*public Node copy(Node p){
        Node q= new Node(p.data);
            Node temp= q;
            p=p.next;

            while(p!=null){
                temp.next=new Node(p.data);
                temp = temp.next;
                p=p.next;
            }
            return q;

    }*/
}
