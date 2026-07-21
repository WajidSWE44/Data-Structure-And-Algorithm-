package Searching;

public class BinarySearchPlusSort {
    //Time complexity = O(n^2)
    public int[] BubbleSort (int[] arr){
        for(int i=0; i< arr.length-1;i++){//n-1
            for(int j=0; j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        return arr;
    }
    public int binarysearch1D(int [] arr,int key,int first,int end){
        int mid;
        while(first<end){
            mid = first+(end -first)/2;

            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                first = mid+1;
            }
            if(arr[mid]>key){
                end = mid-1;
            }
        }
        return -1;
    }

    int dublicate( int arr[],int key,int mid){
        int count = 1;
        int  i = mid;
        while (arr[i+1]==key){
            count++;
            i++;
        }
        i=mid;
        while(arr[i-1]==key){
            count++;
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySearchPlusSort b = new BinarySearchPlusSort();
        int[]arr ={5,2,2,1,8,7,4,6};
        arr = b.BubbleSort(arr);
        for(int i: arr) {
            System.out.print(i+" ");
        }
        int index1 = b.binarysearch1D(arr,7,0, arr.length-1);
        int index2 = b.binarysearch1D(arr,4, 0,arr.length-1);
        System.out.println("\nelement found at the index of:"+index1);
        System.out.println("\nelement found at the index of:"+index2);

       int result = b.dublicate(arr,2,2);
        System.out.println(result);







 }
}
