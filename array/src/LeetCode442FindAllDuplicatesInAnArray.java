import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
*/

public class LeetCode442FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> newList = new ArrayList<>(nums.length);
/*

        // 第一步，新建一个数组array，长度与nums相同，初始化全部为1
        // 对nums进行遍历，以nums[i] - 1(减 1 是为了不越界)的值index做为array的索引
        // 如果array[index]为正，则表示第一次出现，array[index] = -array[index]
        // 如果array[index]为负，则表示第二次出现
        int[] array = new int[nums.length];
        for(int i = 0; i < array.length; i ++) {
            array[i] = 1;
        }
        int index = -1;
        for(int i = 0; i < nums.length; i ++) {
            index = nums[i] - 1;

            if(array[index] > 0) {
                array[index] = - array[index];
            } else {
                newList.add(nums[i]);
                array[index] = 0;
            }
            System.out.println(Arrays.toString(array));
        }
*/

        // 第二步，直接把nums看做array
        // 对nums进行遍历，以nums[i] - 1的值index做为nums的索引
        // 如果nums[index]为正，则表示第一次出现，nums[index] = -nums[index]
        // 如果nums[index]为负，则表示第二次出现，放入newList中
        int index = -1;
        for(int i = 0; i < nums.length; i ++) {
            index = Math.abs(nums[i]) - 1;

            if(nums[index] < 0) {
                newList.add(Math.abs(nums[i]));
            }

            nums[index] = - nums[index];

        }

        return newList;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> ret = LeetCode442FindAllDuplicatesInAnArray.findDuplicates(nums);
        System.out.println(ret.toString());
    }
}
