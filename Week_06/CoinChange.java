//题号：322
//https://leetcode-cn.com/problems/coin-change/
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1107 👎 0


public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {

            /**
             * 动态规划：
             *
             * 最优子结构为f(n)=f(n-c)+1
             * 上面的1我是这么理解的，你从f(n-c)到f(n),会花费一枚硬币，因此要+1
             *
             *
             * 1、找重复性：program(i)=Math.min(subProgram(i-1),subProgram(i-3),subProgram(i-5))+1
             * 2、状态数组定义：dp[],这里dp存的是最少的硬币数,n代表的是金额数
             * 3、状态转移方程：dp[i]=Math.min(dp[i-1],dp[i-3],dp[i-5])+1;
             *
             * 时间复杂度O(m*n),空间复杂度O(n)
             *
             */

            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                int min = amount + 1;
                for (int j = 0; j < coins.length; j++) {
                    //下面这样写是为了保证dp[i]是dp[i-coin[j]]里最小的，两种写法都行，
                    //还有种写法是先给数组赋值，然后在比，其实都是为了保证最小
                    if (i - coins[j] >= 0 && dp[i - coins[j]] + 1 < min) {
                        min = dp[i - coins[j]] + 1;
//                if (i - coins[j] >= 0) {
//                    min = Math.min(dp[i - coins[j]] + 1, min);
                    }
                }
                dp[i] = min;
            }

            return dp[amount] > amount ? -1 : dp[amount];


//        int max = amount + 1;
//        int dp[] = new int[amount + 1];
//        Arrays.fill(dp, max);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}