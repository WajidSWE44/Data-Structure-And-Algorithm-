package Sort;

public class SelectionSort {
    public void PrintArray(int arr[]){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int [] arr = {7,8,3,21,2};

        for(int i=0; i< arr.length-1 ; i++){
            int smaller = i;
            for(int j=i+1 ;j< arr.length; j++){
                if(arr[smaller] > arr[j]){
                    smaller =j;

                    //bs.PrintArray(arr);
                }
            }
            int temp = arr[smaller];
            arr[smaller] = arr[i];
            arr[i] = temp;
        }
        ss.PrintArray(arr);
    }
}
