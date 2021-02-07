//题号：49
//
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 652 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
      public static void main(String[] args) {
           Solution solution = new GroupAnagrams().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        /**
         * 法一：排序+hashMap
         *
         * 时间复杂度O(nlogn)，空间复杂度O(n)
         *
         */

//        if (strs == null || strs.length == 0) {
//            return new ArrayList<>();
//        }
//
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String keyStr = String.valueOf(ca);
//            if (!map.containsKey(keyStr)) {
//                map.put(keyStr, new ArrayList<>());
//            }
//            map.get(keyStr).add(s);
//        }
//
//        return new ArrayList<>(map.values());


        /**
         * 法二：无排序，自建key值
         *
         * 时间复杂度O(n*26)，空间复杂度O(n)
         *
         */

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {

            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }

            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }