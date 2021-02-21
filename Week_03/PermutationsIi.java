//题号：47
//https://leetcode-cn.com/problems/permutations-ii/
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 593 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        recur(res, new ArrayList<>(), visited, nums);

        return res;
    }

          private void recur(List<List<Integer>> res, List<Integer> subRes, boolean[] visited, int[] nums) {
              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  if (visited[i]||i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
                  visited[i] = true;
                  subRes.add(nums[i]);
                  recur(res, subRes, visited, nums);
                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }