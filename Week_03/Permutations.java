//题号：46
//https://leetcode-cn.com/problems/permutations/
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1142 👎 0


import java.util.ArrayList;
import java.util.List;

public class Permutations {
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recur(res, new ArrayList<>(), visited, nums);

        return res;

    }

          private void recur(List<List<Integer>> res, List<Integer> subRes, boolean[] visited,int[] nums) {

              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  //list.contains()这个是O(n)的时间复杂度,可以用数组或map优化为O(1)
//                  if (subRes.contains(nums[i])) continue;//存在元素则跳过
                  if (visited[i]) continue;
                  visited[i] = true;
                  subRes.add(nums[i]);
                  recur(res, subRes,visited,nums);
                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
              }






          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }