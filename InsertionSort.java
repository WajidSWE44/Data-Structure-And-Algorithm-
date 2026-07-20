public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={5,6,2,3,1};
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
/*Let’s take the following array: {5, 6, 2, 3, 1}

Suppose i = 2 and the key is 2. The while loop will compare arr[j] (which starts at 6, the element before 2):

First iteration:

j = 1: arr[j] = 6 and key = 2.
Since arr[j] > key, arr[j + 1] = arr[j] makes the array {5, 6, 6, 3, 1}.
Now j is decremented to 0.
Second iteration:

j = 0: arr[j] = 5 and key = 2.
Again, arr[j] > key, so arr[j + 1] = arr[j] makes the array {5, 5, 6, 3, 1}.
Now j is decremented to -1, exiting the while loop.
After the loop ends, arr[j + 1] = key places 2 in its correct position:

{2, 5, 6, 3, 1}.*/

    }
}
