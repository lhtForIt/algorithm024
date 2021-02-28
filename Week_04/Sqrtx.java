//题号：69
//https://leetcode-cn.com/problems/sqrtx/
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 605 👎 0


public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        solution.mySqrt(2147395599);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {

            /**
             * 二分查找
             *
             * 时间复杂度O(logn)，空间复杂度O(1)
             *
             * 为啥是返回right而不是left?我理解是走到这里平方数一定是小数，int是直接截取小数部分，因此要取小的那个
             * 这时候left>right，所以是right
             *
             */
            if (x < 2) {
                return x;
            }

            //当数值大到一定值时，mid * mid超过int上限，会一直得到负数，从而得不到正确值
            //所以这里应该用long
            long left = 0, right = x, mid = 1;


            while (left <= right) {
                mid = left + (right - left) / 2;
                if (mid * mid == x) {
                    return (int) mid;
                } else if (mid * mid < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return (int)right;

            /**
             * 牛顿迭代法，
             * r = (r + x/ r) / 2; 不断迭代这个公式，
             * r会不断逼近完全平方根，
             * 后面判断可以直接用r*r和x比,
             * 也可以用r<1e-7去比
             */


//            if (x == 0) {
//                return 0;
//            }
//
////            long r = x;
////            while (r*r>x) {
////                r = (r + x/ r) / 2;
////            }
//
////            return (int)r;
//
//            double C = x, x0 = x;
//            while (true) {
//                double xi = (x0 + C / x0)/2;
//                if (Math.abs(x0 - xi) < 1e-7) {
//                    break;
//                }
//                x0 = xi;
//            }
//            return (int) x0;










        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}