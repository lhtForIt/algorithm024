//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 249 👎 0

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int count = 0;
    private int size;

    public int totalNQueens(int n) {

        /**
         * 数组缓存的递归
         * 时间复杂度：O(n!)
         * 空间复杂度：O(n+2n-1+2n-1)
         *
         */

//        boolean[] cols = new boolean[n];
//        boolean[] pie = new boolean[2 * n - 1];
//        boolean[] na = new boolean[2 * n - 1];
//
//
//        dfs(0, cols, pie, na, n);
//
//        return count;


        /**
         * 位运算
         * 时间复杂度：O(n!)
         * 空间复杂度：O(1)
         */

         size=(1<<n)-1;//2n-1
         dfsWithBit(0, 0, 0);

        return count;


    }

        private void dfsWithBit(int row, int pie, int na) {

            if (row == size) {
                count++;
                return;
            }

            int pos = size & (~(row | pie | na));
            while (pos != 0) {
                int p = pos & (-pos);
                pos -= p;//pos&=pos-1;
                dfsWithBit(row | p, (pie | p) << 1, (na | p) >> 1);
            }

        }

        private void dfs(int row, boolean[] cols, boolean[] pie, boolean[] na, int n) {

            if (row == n) {
                count++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (cols[i] || pie[row + i] || na[row - i + n - 1]) {
                    continue;
                }

                cols[i] = true;
                pie[row + i] = true;
                na[row - i + n - 1] = true;

                dfs(row + 1, cols, pie, na, n);
                cols[i] = false;
                pie[row + i] = false;
                na[row - i + n - 1] = false;

            }



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}