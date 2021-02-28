//题号：367
//https://leetcode-cn.com/problems/valid-perfect-square/solution/
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 194 👎 0


public class ValidPerfectSquare {
    public static void main(String[] args) {
         Solution solution = new ValidPerfectSquare().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean isPerfectSquare(int num) {

      /**
       * 二分：时间复杂度O(logN),空间复杂度O(1)
       */
      if (num < 2) {
          return true;
      }

      long left = 2, right = num / 2, x, pinfang;
      while (left <= right) {
          //防止溢出
          x = left + (right - left) / 2;
          pinfang = x * x;
          if (pinfang == num) {
              return true;
          }else if (pinfang > num) {
              right = x - 1;
          } else {
              left = x + 1;
          }

      }

      return false;
  }

      /**
       * 牛顿迭代法
       * 时间复杂度O(logN)，空间复杂度O(1)
       */

//        if (num < 2) {
//            return true;
//        }
//        long x = num / 2;
//        while (x * x > num) {
//            x = (x + num / x) / 2;
//        }
//
//        return x * x == num;


  }

//leetcode submit region end(Prohibit modification and deletion)

}