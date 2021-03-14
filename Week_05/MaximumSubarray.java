//题号：53
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2947 👎 0


public class MaximumSubarray {
    public static void main(String[] args) {
         Solution solution = new MaximumSubarray().new Solution();
        solution.maxSubArray(new int[]{5,4,-1,7,8});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxSubArray(int[] nums) {


      /**
       * 因为这个有连续性，一旦Nums[i]不要，
       * 那就只能从新开始从nums[i]开始，不能跳着取
       *
       * 因此状态转移方程为dp[i]=Math.max(dp[i-1]+nums[i],nums[i]).
       *
       * 且dp方程记录的是每个位置的最大值，但是最后一个位置不一定是全局最大值，
       * 因此需要一个变量在遍历的时候记录最大值
       *
       * 时间复杂度O(n)，空间复杂度O(n)
       *
       */
//        int max = nums[0];
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        //有i-1，i要从1开始
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//            max = Math.max(max, dp[i]);
//        }
//
//
//        return max;


      /**
       * 其实可以在原数组上直接进行缓存存储，直接用Nums代替dp进行计算
       *
       * 时间复杂度O(n)，空间复杂度O(1)
       *
       */

//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
//            max = Math.max(max, nums[i]);
//        }
//
//
//        return max;


      /**
       * 动态规划优化：
       * 因为都是从前往后推的，只会用到dp[i-1]，
       * 因此可以直接用一个变量记录，将复杂度降到了O(1)
       *
       * max的默认值要是nums[0]，否则只有一个负数时会错取了preMax的值，0
       *
       * 时间复杂度O(n)，空间复杂度O(1)
       */

      int max = nums[0];
      int preMax = 0;

      for (int i = 0; i < nums.length; i++) {

          preMax = Math.max(preMax + nums[i], nums[i]);
          max = Math.max(preMax, max);

      }


      return max;



  }
}
//leetcode submit region end(Prohibit modification and deletion)

}