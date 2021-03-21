//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 483 👎 0

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {

        /**
         * 用set保存访问数据
         * 时间复杂度O(1)（每个只访问了一次），空间复杂度O(n)
         */
//        Set seen = new HashSet();
//        for (int i=0; i<9; ++i) {
//            for (int j=0; j<9; ++j) {
//                char number = board[i][j];
//                if (number != '.')
//                    if (!seen.add(number + " in row " + i) ||
//                            !seen.add(number + " in column " + j) ||
//                            !seen.add(number + " in block " + i/3 + "-" + j/3))
//                        return false;
//            }
//        }
//        return true;


        /**
         * 用数组存访问记录
         * 时间复杂度O(1)，空间复杂度O(n)
         *
         * 好像一般把Set换成数组都能快不少呢，
         * 但数组有个不好的地方是你需要提前知道存储元素的大小，
         * 有的时候size是未知的
         *
         */

        for(int i = 0;i < 9;i++){
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for(int j = 0;j< 9;j++){
                if (board[i][j] == '.') {
                } else if (rowCheck[board[i][j] - '1']) {
                    return false;
                } else {
                    rowCheck[board[i][j] - '1'] = true;
                }
                if (board[j][i] == '.') {
                } else if (colCheck[board[j][i] - '1']) {
                    return false;
                } else {
                    colCheck[board[j][i] - '1'] = true;
                }
                int m = i/3*3 + j/3;
                int n = i%3*3 + j%3;
                if (board[m][n] == '.') {
                } else if (boxCheck[board[m][n] - '1']) {
                    return false;
                } else {
                    boxCheck[board[m][n] - '1'] = true;
                }
            }
        }
        return true;

    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}