public class Main {
    public static void main(String[] args) {


        for(int i = 4; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.print("Hello world!");
        for(int i = 4; i >= 0; i--) {
            for (int j = i; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}