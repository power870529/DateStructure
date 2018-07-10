/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
*/

public class LeetCode283MoveZeroes {

    public void moveZeroes(int[] nums) {

        int j = -1;
        // 类似快速排序，数组nums[0...j] > 0，nums[j+1...i] = 0
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = temp;
                j ++;
            }
        }
    }
}
