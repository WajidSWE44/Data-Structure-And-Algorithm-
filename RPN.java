package Stack;

class RPN {

    public RPN(String[] args) {
        ArrayStack rpn = new ArrayStack(args.length);  // Create the stack

        for (int i = 0; i < args.length; i++) {
            String input = args[i];

            // If the input is an operator, pop two numbers from the stack and evaluate
            if (isAnOperator(input)) {
                double y = Double.parseDouble((String) rpn.pop());
                double x = Double.parseDouble((String) rpn.pop());
                double z = evaluate(x, y, input);

                // Push the result back onto the stack
                rpn.push(" "+z);

            } else {
                // If the input is a number, push it onto the stack
                rpn.push(input);
            }
        }

        // After evaluation, the result should be at the top of the stack
        System.out.println("Final result: " + rpn.pop());
    }

    // Helper function to check if the string is an operator
    private boolean isAnOperator(String s) {
        // Should be index >= 0 (change from > 0)
        return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
    }

    // Evaluate the expression based on the operator
    private double evaluate(double x, double y, String s) {
        double z = 0;
        if (s.equals("A")) z = x + y;    // Addition
        else if (s.equals("S")) z = x - y; // Subtraction
        else if (s.equals("M")) z = x * y; // Multiplication
        else if (s.equals("D")) z = x / y; // Division
        else System.out.println("Operator not matched");

        return z;
    }

    public static void main(String[] args) {
        // Example RPN expression: (3 + 4) / (5 - 3) + 3
        String[] s = { "3", "4", "A", "5", "3", "S", "D", "3", "A" };

        // Create a new RPN calculator with the expression
        RPN rpn = new RPN(s);
    }
}

/*public class RPNCalculator {
    RPNCalculator(String[] Arrays){
        Stack rpn=new ArrayStack(Arrays.length);
        for (int i=0;i<Arrays.length;i++){
            String Input=Arrays[i];
            if (isOperator(Input)){
                double y = Double.parseDouble((String) rpn.pop());
                double x = Double.parseDouble((String)rpn.pop());
                double z = evaluate(x, y, Input);
                rpn.push(" "+z);
            }
            else rpn.push(Input);
        }
        System.out.println(rpn.peek());
    }
    private  boolean isOperator(String operator){
        if(operator.length()==1&& "ASMD".contains(operator)){
            return true;
        }
        return false;
    }
    private  double evaluate(double x,Double y,String operator){
        double Z=0;

        if (operator.equals("A")) Z=x+y;
        else if (operator.equals("S")) Z = x-y;
        else if (operator.equals("M")) Z= x*y;
        else if (operator.equals("D")) Z=x/y;
        else System.out.println("operator not matched");
        return Z;
    }
    public static void main(String[] args) {
        String[] Expression={"3","4","A","5","3","S","D","3","A"};
        RPNCalculator rpn=new RPNCalculator(Expression);
    }
}**/




/*package Stack;
import Stack.ArrayStack;
class RPN{
    public RPN(String[] args){
        ArrayStack rpn = new ArrayStack(args.length);
        for(int i=0; i< args.length;i++){
            String input = args[i];
            if(isAnOperator(input)){
                double y = Double.parseDouble((String)rpn.pop());
                double x = Double.parseDouble((String)rpn.pop());
                double z = evaluate(x,y,input);
               // rpn.push("",z);
            }
            rpn.push(input);
        }
    }
    private boolean isAnOperator(String s){
        return (s.length()==1 && "ASMD".indexOf(s)>0);
    }

    private double evaluate(double x,double y,String s){
        double z=0;
         if (s.equals("A")) z=x+y;
        else if (s.equals("S")) z = x-y;
        else if (s.equals("M")) z= x*y;
        else if (s.equals("D")) z=x/y;
        else System.out.println("operator not matched");

        return z;


    }
    public static void main(String[] args) {

        String[] Expression={"3","4","A","5","3","S","D","3","A"};

        RPN rpn=new RPN(Expression);



    }


}*/
