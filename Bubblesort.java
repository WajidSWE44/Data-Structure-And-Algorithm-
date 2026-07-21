package Searching;

public class Bubblesort {

    public static void main(String[] args) {

        int arr[] = {1,3,7,5,2};

        for(int i =0; i< arr.length;i++){
            for(int j=0; j< arr.length-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    //System.out.print(temp);
                }
            }
        }
        for(int i=0; i<arr.length ;i++){
            System.out.print(arr[i]);
        }
        System.out.println(" ");
    }
}
