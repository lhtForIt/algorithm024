//题号：1
//https://leetcode-cn.com/problems/two-sum/
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10131 👎 0


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            /**
             * 法一，暴力解法，时间复杂度为0（n2）,空间复杂度O(1)
             */
            //这里i最大值只会到nums.length-2,注意：以后遇到多重循环嵌套且前后有比较关系，可以将第一层循环减少相应嵌套层数
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//
//            return null;


            /**
             * 法二，引入hashMap，加上缓存，时间复杂度为O(n),空间复杂度为O(n)
             */


            Map<Integer, Integer> targetMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (targetMap.containsKey(nums[i])) {
                    return new int[]{targetMap.get(nums[i]), i};
                }
                targetMap.putIfAbsent(target - nums[i], i);
            }



            return null;




        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}