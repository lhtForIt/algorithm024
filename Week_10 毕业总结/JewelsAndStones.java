//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表 
// 👍 634 👎 0

public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numJewelsInStones(String jewels, String stones) {

            /**
             * 暴力
             * 时间复杂度O(mn) m,n为两个字符串长度
             * 空间复杂度O（1）
             */

//            int count = 0;
//            for (char c : jewels.toCharArray()) {
//                for (char s : stones.toCharArray()) {
//                    if (c == s) {
//                        count++;
//                    }
//                }
//            }
//
//            return count;

            /**
             * hashMap记录石头记录，然后在O(1)的时间复杂度拿到结果，
             * 在以前做hashMap的题的时候，有很多优化是将Map里数据直接用数组存(在已知大小的情况下)，
             * 所以直接可以用数组代替Map
             *
             * 时间复杂度O(m+n)
             * 空间复杂度O(1)
             */

            int[] chars = new int[128];

            for (char c : jewels.toCharArray()) {
                chars[c]++;
            }

            int res = 0;
            for (char c : stones.toCharArray()) {
                res += chars[c];
            }

            return res;




        }
}
//leetcode submit region end(Prohibit modification and deletion)

}