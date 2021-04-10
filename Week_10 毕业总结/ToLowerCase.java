//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 146 👎 0

public class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
        solution.toLowerCase("Hello");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String toLowerCase(String str) {


            if (str == null | str.length() == 0) {
                return "";
            }

//            char[] chars = new char[26];
//
//            for (int i = 0; i < 26; i++) {
//                chars[i] = (char) ('a' + i);
//            }

            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i]>='A'&&charArray[i]<='Z') {
//                    charArray[i] = chars[str.charAt(i) - 'A'];
                    // 利用所有大写字母ASCII码可以通过+32变成小写字母
                    charArray[i] += 32;
                }
            }


            return new String(charArray);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}