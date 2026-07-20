 class Nodes {
    int data ;
    Nodes next;
    Nodes(int data){
        this.data=data;

    }

}
class node{
    public node(int data) {
    }

    public static void main(String[] args) {
        //First Method.
        Nodes Start = new Nodes(11);
        Start.next=new Nodes(22);
        Start.next.next=new Nodes(33);
        Start.next.next.next=new Nodes(44);
        Start.next.next.next.next= new Nodes(55);

        System.out.println(Start.data);
        System.out.println(Start.next.data);
        System.out.println(Start.next.next.data);




        //Second Method//

        Nodes head = new Nodes(11);
        Nodes p = Start;
        p.next =new Nodes(22);
        p=p.next;
        p.next=new Nodes(33);
        p=p.next;
        p.next=new Nodes(44);
        p=p.next;
        p.next=new Nodes(55);
        p=p.next;

        //Compress the Second method;

        for(int i=0; i<4; i++){
            p.next=new Nodes(i*11+22);
            p=p.next;
            System.out.println(p.data+"\t"+p);
        }


     //use loop that traverses the list and prints the data for each node
        for(Nodes q=Start; q!=null; q=q.next){
            System.out.println(q.data);
        }

    }
}

