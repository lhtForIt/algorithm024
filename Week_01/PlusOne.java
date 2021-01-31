//66
//https://leetcode-cn.com/problems/plus-one/
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 617 👎 0

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        solution.plusOne(new int[]{9, 9, 9});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {

//        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i]++;
//            digits[i] %= 10;
//            if (digits[i] != 0) {
//                return digits;
//            }
//        }
//
//        //能走到这里只有一种可能，就是9999这种，需要多近一位，new一个全是0的数组即可，然后直接首位赋值1就行
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//
//        return digits;

            for (int i = digits.length - 1; i >= 0; i--) {

                /**
                 * 这儿有两种写法，效果都差不多，但是第二种会优雅(elegant)很多
                 */
                /**
                 * 法一：先计算再判断是否溢出
                 */

//            digits[i] %= 10;
//            digits[i]++;
//            if (digits[i] != 0) {
//                return digits;
//            }

                /**
                 * 法二：先判断是否溢出再计算
                 */

                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;

            }

            digits = new int[digits.length + 1];
            digits[0] = 1;

            return digits;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}