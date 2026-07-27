package Sort;

public class InsertionSort {
    public void PrintArray(int arr[]){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int [] arr = {7,8,3,1,2};

        for(int i=1; i< arr.length ; i++){
            int current = arr[i];
            int j=i-1;

            while(j>=0 && current<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            //Placement
            arr[j+1] = current;
            is.PrintArray(arr);//print each iteration
        }
        is.PrintArray(arr);//final result
    }


}

