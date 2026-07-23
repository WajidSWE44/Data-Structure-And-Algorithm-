package Stack;

public class StackCombine implements stack {
    Object[] a;
    int size=0;
    StackCombine(int capacity){
        a=new Object[capacity];
    }
    @Override
    public void push(Object data) {
        if (size==a.length) {
            resize();
        }
        a[size++]=data;
    }
    @Override
    public Object pop() {
        if(size==0){
            throw new IllegalStateException("Stack underflow...");
        }
        Object x=a[--size];
        return x;
    }
    @Override
    public Object peek() {
        if(size==0)
            throw new IllegalStateException("Stack underFlow");
        return a[size-1];
    }

    public boolean isEmpty() {
        return size==0;
    }
    public void resize(){
        Object[] temp=a;
        a=new Object[a.length*2];
        System.arraycopy(temp, 0, a, 0, size);
    }
    @Override
    public int size() {
        return size;
    }
    public void displayStack(StackCombine s){
        int size=s.size();
        StackCombine temp=new StackCombine(size);
        while (size>0) {
            Object x=s.pop();
            System.out.println("| "+x+" |");
            temp.push(x);
            size--;
        }
        System.out.println("-----");
        while (temp.size()>0) {
            s.push(temp.pop());
        }

    }
    public void merge(StackCombine s1, StackCombine s2, StackCombine s3){
        StackCombine s4=new StackCombine(size);
        while(s1.size()>0){
            s4.push(s1.pop());
        }
        while(s2.size()>0){
            s4.push(s2.pop());
        }
        while(s3.size()>0){
            s4.push(s3.pop());
        }
        s4.displayStack(s4);
    }
    public static void main(String[] args) {
        StackCombine s1=new StackCombine(3);
        StackCombine s2=new StackCombine(3);
        StackCombine s3=new StackCombine(3);

        s1.push("AC");
        s1.push("AP");
        s1.push("PF");

        s2.push("LAAG");
        s2.push("ISE");
        s2.push("OOP");

        s3.push("DSA");
        s3.push("SRE");
        s3.push("DBMS");

        s1.displayStack(s1);
        s2.displayStack(s2);
        s3.displayStack(s3);

        s1.merge(s1, s2, s3);


    }
}
