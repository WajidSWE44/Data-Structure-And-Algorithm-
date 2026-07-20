public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        // Step 1: Move non-zero elements forward
        int index = 0; // Keeps track of where the next non-zero element should go
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        // Step 2: Fill the remaining positions with zeros
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        // Output the result
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: [1, 3, 12, 0, 0]
    }
}
