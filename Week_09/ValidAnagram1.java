//题号：242
//https://leetcode-cn.com/problems/valid-anagram/
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 336 👎 0


public class ValidAnagram1 {
      public static void main(String[] args) {
           Solution solution = new ValidAnagram1().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        //只会有26个字母，且都是小写
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;













        /**
         * 法一：直接用封装的hashMap
         * 时间复杂度O（n）,空间复杂度O(n)
         */

//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> charMap = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : t.toCharArray()) {
//            int count = charMap.getOrDefault(c, -1) - 1;
//            //这里只要在这里面动态判断是否小于0即可
//            if (count < 0) {
//                return false;
//            }
//            charMap.put(c, count);
//        }
//        return true;


        /**
         * 法二：用数组代表哈希表
         * 哈希表主要是key-value映射能为我们省去大量查询时间，这种数据量很大的
         * 情况下确实很有用，但对于数据量和mapping关系已知(26个字母)的情况下，我们可
         * 以用数组替代，从而省去了mapping的操作
         *
         * 时间复杂度O(n),空间复杂度O(1) 26
         *
         */

//        if (s.length() != t.length()) {
//            return false;
//        }
//        //只会有26个字母，且都是小写
//        int[] table = new int[26];
//
//        for (char c : s.toCharArray()) {
//            table[c - 'a']++;
//        }
//
//        for (char c : t.toCharArray()) {
//            if (--table[c - 'a'] < 0) {
//                return false;
//            }
//        }
//
//        return true;

        /**
         * 法三，排序直接比较，复杂度太高，不推荐
         * 时间复杂度O(nlogn)，空间复杂度O(logn)
         */

//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }