//题号：387
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 364 👎 0


public class FirstUniqueCharacterInAString {
      public static void main(String[] args) {
           Solution solution = new FirstUniqueCharacterInAString().new Solution();
          solution.firstUniqChar("loveleetcode");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        /**
         * 也是统计字母出现次数，但是用map记录
         */

//        if (s.isEmpty()) {
//            return -1;
//        }
//
//        Map<Character, Integer> countMap = new HashMap<>(s.length());
//        for (int i = 0; i < s.length(); i++) {
//            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            //这里是只出现一次是1不是不出现0，好低级的错误
//            if (countMap.get(c) == 1) {
//                return i;
//            }
//        }
//
//        return -1;


        /**
         * hash表底层是数组，在对于目标size已知的情况下可以直接用数组存储
         */

        //代表'a'-'z'这些字符出现的次数
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //这儿可以'z'-c也可以c-'a'，是一样的，保证统一即可
            chars['z' - c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars['z' - c] == 1) {
                return i;
            }
        }

        return -1;


        /**
         * 运用HashMap+queue
         */

//        if(s.length() == 0) return -1;
//        if(s.length() == 1) return 0;
//        Deque<Integer> queue = new LinkedList<>();
//
//        HashMap<Character,Integer> set = new HashMap<>();
//
//        for(int i= 0; i<s.length();i++){
//            if(!set.containsKey(s.charAt(i))){
//                set.put(s.charAt(i),1);
//                queue.offer(i);
//            }else {
//                set.put(s.charAt(i),set.get(s.charAt(i))+1);
//                if(!queue.isEmpty() && s.charAt(i) == s.charAt(queue.peek())){
//                    while(!queue.isEmpty() && set.get(s.charAt(queue.peek())) !=1){
//                        queue.poll();
//                    }
//                }
//            }
//        }
//
//        return (queue.isEmpty()) ? -1 : queue.poll();



    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }