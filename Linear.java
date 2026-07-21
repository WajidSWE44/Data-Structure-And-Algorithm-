package Searching;
import java.util.Scanner;

public class Linear {
    public static void main(String[] args) {
    int n,i,items,c=0;
    int [] a;
    Scanner sc= new Scanner(System.in);
        System.out.println("How many elements do you wants to enter:");
        n = sc.nextInt();
        a = new int[n];
        System.out.println("Enter Element ");
        for(i = 0; i<n ;i++);
         a[i] =sc.nextInt();
        System.out.println("Enter the item  to Find ");
        items = sc.nextInt();
        for(i=0;i<a.length;i++)
            if(a[i]==items){
                c++;
                break;
        }
        if(c>0){
            System.out.println("item exit ");
        }
        else{
            System.out.println("Item Does not exit ");
        }
    }
}
