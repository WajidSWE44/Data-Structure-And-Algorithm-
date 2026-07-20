class Student {
    int id;
    String stdname;

    Student(int id, String stdname) {
        this.id = id;
        this.stdname = stdname;
    }

    public int getId() {
        return id;
    }

    public String getStdname() {
        return stdname;
    }

    @Override
    public String toString() {
        return "ID:" + this.id + ", Name:" + this.stdname;
    }
}

class Book{
    int id;
    String title;
    Book(int id,String title){
        this.id = id;
        this.title = title;
    }
    public int getid(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String toString(){
        return "ID:" + this.id + ", Name:" + this.title;
    }

}

public class ObjectNode {
    Object data;
    ObjectNode next;

    ObjectNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Ali");
        Student s2 = new Student(2, "Ahmed");
        Student s3 = new Student(3, "Wajid");
        Student s4 = new Student(4, "Zain");
        Student s5 = new Student(5, "Adeel");

        ObjectNode start = new ObjectNode(s1);
        ObjectNode p = start;
        p.next = new ObjectNode(s2);
        p = p.next;
        p.next = new ObjectNode(s3);
        p = p.next;
        p.next = new ObjectNode(s4);
        p = p.next;
        p.next = new ObjectNode(s5);


        Book b1 = new Book(101,"Java");
        Book b2 = new Book(111,"DSA");
        Book b3 = new Book(121,"DBS");

        ObjectNode Start =new ObjectNode(b1);
        ObjectNode q =Start;
        q.next =new ObjectNode(b2);
        q = q.next;
        q.next=new ObjectNode(b3);

        System.out.println("Students:");
        for (ObjectNode node = start; node != null; node = node.next) {
            System.out.println(node.data);
        }
        System.out.println("Books:");
        for (ObjectNode node = Start; node != null; node = node.next) {
            System.out.println(node.data);
        }

    }
}
