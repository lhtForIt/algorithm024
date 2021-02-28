//题号：33
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1199 👎 0


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
//        solution.search1(new int[]{1, 2, 4, 5, 6, 7, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                //0到mid有序,且target大于有序部分最大值或者小于最小值，target在另一半里，left=mid+1
                if (nums[0] <= nums[mid] && (nums[mid] < target || target < nums[0])) {
                    left = mid + 1;
                } else if (target > nums[mid] && target < nums[0]) {//这儿0到mid有旋转，判断升序部分，target > nums[mid] && target < nums[0]满足这个条件target在另一部分
                    left = mid + 1;
                } else {
                    right = mid;//否则在前半部分
                }
            }

            return left == right && nums[left] == target ? left : -1;
        }

        public int search1(int[] nums) {

            int left = 0, right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                } else if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }



            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}