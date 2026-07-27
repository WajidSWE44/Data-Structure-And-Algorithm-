package MergeSortImplementation;

public class MergeSortImplementation {
    private static void mergesort(int[] array) {
        int length = array.length;

        if(length<=1) return ;//base case //When the array has only one element, the recursion stops (if (length <= 1) return;).
        int middle = length/2;

        int[] leftArray = new int[middle];
        int[]  rightArray = new int[length- middle];
        int i = 0;//left array
        int j = 0;//right array

        for( ; i< length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            }else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergesort(leftArray);
        mergesort(rightArray);
        merge(leftArray, rightArray, array);
    }
    private static void merge(int[] leftArray, int[] rightArray ,int[] array ){
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int i =0, l = 0, r = 0;//indices

        // check the condition for merging
        while (l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while ( l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};

        mergesort(array);

        for(int i=0; i< array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
}
    /*
    Step-by-Step Explanation with {8, 2, 5, 3, 4, 7, 6, 1}
    Initial Call: mergesort({8, 2, 5, 3, 4, 7, 6, 1})

    length is 8, so the function continues.
    middle is calculated as 8 / 2 = 4.
    Creates leftArray of size 4 and rightArray of size 4.
    Loop to Split Elements:

    For i = 0 to 3:
    These elements are placed in leftArray, so leftArray = {8, 2, 5, 3}.
    For i = 4 to 7:
    These elements go into rightArray, so rightArray = {4, 7, 6, 1}.
            Recursive Calls:

    The function now recursively calls mergesort on both leftArray and rightArray.
    Recursive Step on leftArray = {8, 2, 5, 3}
    Call: mergesort({8, 2, 5, 3})

    length is 4, so the function continues.
    middle is 4 / 2 = 2.
    Creates leftArray = {8, 2} and rightArray = {5, 3}.
            Recursive Calls on {8, 2} and {5, 3}:

    Splits down further until reaching single-element arrays:
    {8}, {2}, {5}, and {3}.
    Merge:

    Now, the function merges {8} and {2} into {2, 8}, and {5} and {3} into {3, 5}.
    Finally, it merges {2, 8} and {3, 5} to get {2, 3, 5, 8}.
    Recursive Step on rightArray = {4, 7, 6, 1}
    Call: mergesort({4, 7, 6, 1})

    length is 4, so the function continues.
    middle is 4 / 2 = 2.
    Creates leftArray = {4, 7} and rightArray = {6, 1}.
            Recursive Calls on {4, 7} and {6, 1}:

    Splits further until reaching {4}, {7}, {6}, and {1}.
    Merge:

    Merges {4} and {7} into {4, 7}, and {6} and {1} into {1, 6}.
    Finally, merges {4, 7} and {1, 6} to get {1, 4, 6, 7}.
    Final Merge: {2, 3, 5, 8} and {1, 4, 6, 7}
    With both halves sorted ({2, 3, 5, 8} and {1, 4, 6, 7}), the final call to merge will combine them into {1, 2, 3, 4, 5, 6, 7, 8}, producing the fully sorted array.

    This recursive approach continues splitting and merging until the entire array is sorted.

    */





    /*
    Step-by-Step Code Execution: Merging {8, 2} and {5, 3} into {2, 3, 5, 8}
Assume we’ve split down to {8, 2} and {5, 3}, which are further split into single elements {8}, {2}, {5}, {3}. Now, we start merging back up.

Merging {8} and {2}:
Inputs:

leftArray = {8}
rightArray = {2}
array = {8, 2} (initially the unsorted subarray)
Code Execution:

int leftSize = array.length / 2; calculates leftSize = 1 (number of elements in leftArray).
int rightSize = array.length - leftSize; calculates rightSize = 1 (number of elements in rightArray).
Initialize i = 0, l = 0, and r = 0 to track positions in array, leftArray, and rightArray, respectively.
Merging Elements:

while (l < leftSize && r < rightSize): Starts the merging loop.
Compare leftArray[l] (8) and rightArray[r] (2).
Since 2 < 8, assign array[i] = rightArray[r], so array[0] = 2.
Increment i and r, so i = 1, r = 1.
Leftover Elements:

while (l < leftSize): Since leftArray still has elements (8), assign array[i] = leftArray[l], so array[1] = 8.
Increment i and l, so i = 2, l = 1.
Final Output of Merge:

The merged result of {8} and {2} is {2, 8}.
Merging {5} and {3}:
Repeat the same process as above:

Inputs:

leftArray = {5}
rightArray = {3}
array = {5, 3}
Merging:

Compare 5 and 3. Since 3 < 5, assign array[0] = 3.
Leftover element 5 goes next, resulting in {3, 5}.
Second Level of Merging: {2, 8} and {3, 5} into {2, 3, 5, 8}
Inputs:

leftArray = {2, 8}
rightArray = {3, 5}
array = {2, 8, 3, 5}
Code Execution:

leftSize = 2, rightSize = 2
Initialize i = 0, l = 0, r = 0.
Merging Elements:

leftArray[l] = 2, rightArray[r] = 3
Since 2 < 3, set array[i] = leftArray[l], so array[0] = 2.
Increment i and l, so i = 1, l = 1.
Compare leftArray[l] = 8 and rightArray[r] = 3.
Since 3 < 8, set array[i] = rightArray[r], so array[1] = 3.
Increment i and r, so i = 2, r = 1.
Compare leftArray[l] = 8 and rightArray[r] = 5.
Since 5 < 8, set array[i] = rightArray[r], so array[2] = 5.
Increment i and r, so i = 3, r = 2.
Leftover Elements:

while (l < leftSize): Remaining element in leftArray is 8, so set array[3] = 8.
Final Output of Merge:

The merged result of {2, 8} and {3, 5} is {2, 3, 5, 8}.
Final Level of Merging: {2, 3, 5, 8} and {1, 4, 6, 7} into {1, 2, 3, 4, 5, 6, 7, 8}
Following similar steps as above, the final merged array becomes {1, 2, 3, 4, 5, 6, 7, 8}, completing the merge sort process
    */


