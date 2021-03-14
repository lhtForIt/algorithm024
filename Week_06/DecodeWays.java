//题号：91
//https://leetcode-cn.com/problems/decode-ways/
//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。 
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 641 👎 0


public class DecodeWays {
      public static void main(String[] args) {
           Solution solution = new DecodeWays().new Solution();
          solution.numDecodings("06");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        /**
         * 动态规划：
         * 1、重复子问题：program(i)=subProgram(i-1)+一个字符+subProgram(i-2)+两个字符组合
         * 2、状态转移数组：dp[]，dp值代表编码总数
         * 3、状态转移方程：dp[i]=dp[i-1]+一个字符+dp[i-2]+两个字符（这时候一个两个字符要分情况讨论）
         *
         * 字符串分情况讨论：
         * 1、当末尾为0，即s.charAt(i)=='0'，这时候只有i-1为1和2才会有效，数字为10/20,超过2找不到编码字母，
         * 前面多少种就是多少种，因此dp[i]=dp[i-2]，不是1或者2则是0
         * 2、i-1为1，i可以为任意数，且可以组成一个或者组成两个dp[i]=dp[i-1]+dp[i-2]
         * 3、i-1为2，i只能小于7，前面已经排除0了，因此是1-6，dp[i]=dp[i-1]+dp[i-2]else dp[i]=dp[i-2]
         *
         */


        if (s.equals("0")) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        //这里的dp[0]我理解知识一个凑数的，为了算出dp[2]
        dp[0] = 1;
        //比如"06"这种，不能直接赋值成1，要根据第一位是什么再赋值
        dp[1] = s.charAt(0) == '0' ? 0 : 1;


        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }

        return dp[s.length()];


        /**
         * 和上面相似的写法
         */

//        if (s.equals('0')) {
//            return 0;
//        }
//
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) == '0' ? 0 : 1;
//
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7') {
//                if (s.charAt(i) == '0') {
//                    dp[i + 1] = dp[i - 1];
//                } else {
//                    dp[i + 1] = dp[i] + dp[i - 1];
//                }
//            } else if (s.charAt(i) == '0') {
//                return 0;
//            } else {
//                dp[i + 1] = dp[i];
//            }
//        }
//
//        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }