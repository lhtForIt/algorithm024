//题号：120
//https://leetcode-cn.com/problems/triangle/description/
//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 709 👎 0


import java.util.List;

public class Triangle {
      public static void main(String[] args) {
           Solution solution = new Triangle().new Solution();
//          solution.minimumTotal(Arrays.asList(new Integer[]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int minimumTotal(List<List<Integer>> triangle) {

              /**
               * 动态规划：这儿只能从下往上推，而不能从上往下，因为从下往上都会走到f[0][0]那个点，
               * 就是最小值，但是从上往下到最后一行，会是多个，推不出来
               *
               * 状态转移数组:f[i][j]=Math.min(f[i+1][j],f[i+1][j+1])+f[i][j];
               *
               * 时间复杂度O(n^2)，空间复杂度O(n^2)
               *
               */
//              if (triangle.isEmpty()) {
//                  return 0;
//              }
//
//              int n = triangle.size();
//              //数组+1，有效防止下标越界
//              int[][] dp = new int[n + 1][n + 1];
//
//
//              /**
//               * 这里是三角形，因此j的最大值只能到i
//               */
//              for (int i = n - 1; i >= 0; i--) {
////                  for (int j = 0; j <= i; j++) {
//                  for (int j = i; j >= 0; j--) {
//                      dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
//                  }
//              }
//
//              return dp[0][0];

              /**
               * 优化，因为每次只会用下一行的数据往上递推，因此
               * dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
               * 可以直接写成dp[j]+Math.min(dp[j],dp[j+1])+triangle.get(i).get(j)
               * 用一维数组代替二位数组
               *
               * 时间复杂度O(n^2)，空间复杂度O(n)
               */

              if (triangle.isEmpty()) {
                  return 0;
              }

              int n = triangle.size();
              int[] dp = new int[n + 1];


              for (int i = n - 1; i >= 0; i--) {
                  //这儿只能从0推到i，不能反着来
                  for (int j = 0; j <= i; j++) {
                      dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                  }
              }

              return dp[0];


          }

}
//leetcode submit region end(Prohibit modification and deletion)

  }