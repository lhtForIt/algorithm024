//题号：77
//https://leetcode-cn.com/problems/combinations/
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        /**
         * 递归法一
         */
//        List<List<Integer>> res = new LinkedList<>();
//        if (k <= 0 || n < k) {
//            return res;
//        }
//
//        Deque<Integer> path = new LinkedList<>();
//
//
//        recur(1,n, k, path,res);
//
//
//        return res;

        /**
         * 递归法二：
         */


//        List<List<Integer>> res = new LinkedList<>();
//        recur1(res, new ArrayList<>(), 1, n, k);
//
//        return res;

        /**
         * 法三
         */

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;










    }

          private void recur1(List<List<Integer>> res, ArrayList<Integer> subRes, int deep, int n, int k) {
              if (k == 0) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = deep; i <= n - k + 1; i++) {
                  subRes.add(i);
                  recur1(res, subRes, i + 1, n, k - 1);
                  subRes.remove(subRes.size() - 1);
              }
          }

          private void recur(int deep, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
              if (k == 0) {
                  res.add(new ArrayList<>(path));
                  return;
              }
              if (deep > n - k + 1) {
                  return;
              }

              // 不选当前考虑的数 begin，直接递归到下一层
              recur(deep + 1, n, k, path, res);

              // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
              path.addLast(deep);
              recur(deep + 1, n, k - 1, path, res);

              //清楚状态
              path.removeLast();
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }