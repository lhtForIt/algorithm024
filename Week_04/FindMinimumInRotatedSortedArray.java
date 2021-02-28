//题号：153
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 357 👎 0


public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
         Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        solution.findMin(new int[]{11,13,15,17});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int findMin(int[] nums) {


      /**
       * 这个题的思路其实就是找到有序区间的最大值，然后最大值下一位就是旋转位，也即是最小值
       * 注意边界判断
       */

      if (nums[nums.length - 1] > nums[0]) {
          return nums[0];
      }

      int left = 0, right = nums.length - 1;

      while (left <= right) {

          int mid = left + (right - left) / 2;

          if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
              return nums[mid + 1];
          } else if (nums[mid] >= nums[0]) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }



      return nums[right];
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}