package Stack;


class ArrayStack implements stack {
    Object[] a;
    int size;
    public ArrayStack(int capacity){
        a= new Object[capacity];
    }
    @Override
    public Object peek() {
        if(size==0)throw new IllegalStateException("Stack is empty");
        return a[size-1];
    }

    @Override
    public Object pop() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        Object temp = a[--size];
        a[size] = null; // Corrected the assignment
        return temp;
    }

    @Override
    public void push(Object obj) {
      //if(size==a.length);
      //resize();
       a[size++] = obj;

    }


    @Override
    public int size() {
        return size;
    }
}



public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("apple");
        stack.push("cheku");
        stack.push("graps");
        System.out.print(" "+"peek= "+stack.peek());
        System.out.print("  "+"size= "+stack.size());
        System.out.println("  "+"pop= "+stack.pop());


        System.out.print(" "+"peek= "+stack.peek());
        System.out.print("  "+"size= "+stack.size());
        System.out.println("  "+"pop= "+stack.pop());

       /* RPN rpn = new RPN();
        String[] s= {"7","2","A","5","8","4","D","S","M"};
        if(s.equals("A"))
            z = x+y;*/




    }
}
