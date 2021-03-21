//题号：22
//https://leetcode-cn.com/problems/generate-parentheses/
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1565 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GenerateParentheses4DP {
      public static void main(String[] args) {
          Solution solution = new GenerateParentheses4DP().new Solution();
          solution.generateParenthesis(3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        /**
         * 动态规划法一：
         *
         * 中国站的动态规划感觉写的不是很好，不易于理解，通过全国站这个
         * 去理解吧
         * 主要就是分为左右两个部分，然后动态转移方程为S[n]="("+s[n-1-i]+")"+s[i]
         *
         *
         * Keypoints: divide pattern into left and right part.
         * Left part is wrapped by symbol "(" and ")".
         * So, we get the sequence with these pattern. (LEFT)RIGHT.
         *
         * F[0] = [""]
         *
         * F[1] = (F[0])F0[0] = ["()"]
         *
         * F[2] = (F[0])F[1], (F[1])F[0]
         * -> (F[0])F[1] = ()F[1] = ()() = ["()()"]
         * -> (F[1])F[0] = (())F[0] = (()) = ["(())"]
         * so, F[2] = ["()()", "(())"]
         *
         * F[3] = (F[0])F[2], (F[1])F[1], (F[2])F[0] = ["()()()", "()(())", "(())()", "(()())", "((()))"]
         *
         */

        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList("")));
        for (int i=1; i<=n; i++) {
        //这儿每次右边对应的都是i-1-j,第一次j是0，因此右边就是i-1，后面因为j++,k--始终让k就是右边的值
            for (int j=0, k=i-1; j<i; j++, k--) {
                for (String left : map.get(j)) {
                    StringBuilder sb1 = new StringBuilder();
                    sb1 = sb1.append("(");
                    sb1 = sb1.append(left);
                    sb1 = sb1.append(")");
                    for (String right : map.get(k)) {
                        StringBuilder sb2 = new StringBuilder(sb1);
                        String tmp = sb2.append(right).toString();
                        if (!map.containsKey(i)) {
                            map.put(i, new ArrayList<>(Arrays.asList(tmp)));
                        } else {
                            map.get(i).add(tmp);
                        }
                    }
                }
            }
        }
        return map.get(n);


        /**
         * 动态规划法二：
         * f(n) = [ (f(0))f(n-1), (f(1))f(n-2), ..., (f(n-1)) ], andf(0) = "".
         *
         * 动态转移方程S(n)="("+S(n-1-i)+")"+S(i)
         */


//        List<List<String>> parens = new ArrayList<>();
//        List<String> zero_list = Arrays.asList("");
//        parens.add(zero_list);
//        for (int i = 1; i < n + 1; i++) {
//            List<String> n_list = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                for (String s1: parens.get(j)) {
//                    for (String s2: parens.get(i - j - 1)) {
//                        n_list.add('(' + s1 + ')' + s2);
//                    }
//                }
//            }
//            parens.add(n_list);
//        }
//        return parens.get(n);


        /**
         * 动态规划法三：
         * 大概看了下，这个和上面法二一样的，但是丑了很多，感觉像是抄的全国站的解法。。。理解上面解法即可
         *
         */

//        List<List<String>> res = new ArrayList<>();
//
//        List<String> list = new ArrayList<>();
//        list.add("");
//        res.add(list);
//
//
//        for (int i = 1; i <= n; i++) {
//            List<String> cur = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                //note:i+j=n-1
//                List<String> str1 = res.get(j);
//                List<String> str2 = res.get(i - j - 1);
//
//                for (String s1 : str1) {
//                    for (String s2 : str2) {
//                        String temp = "(" + s1 + ")" + s2;
//                        cur.add(temp);
//                    }
//                }
//            }
//            res.add(cur);
//        }
//
//        return res.get(n);














        /**
         * dfs
         */

//        List<String> res = new ArrayList<>();
//        dfs(0, 0, n, res, "");
//        return res;


        /**
         * dfs优化
         *
         * 在原来dfs的基础上可以将字符串拼接改成char[]数组赋值，减去了
         * string在拼接的时候的时间动态构建StringBuilder的消耗
         *
         */

//        List<String> res = new ArrayList<>();
//        //这里第三个参数i是用来记录char当前层的位置的
//        dfsChars(0, 0, 0, n, res, new char[2 * n]);
//
//        return res;



        /**
         * bfs
         * 有的题解说下面这种解法是BFS,
         * 但是我看着不像BFS，因为它没有拿到当前queue的size去遍历的过程，也就是没有每层去
         * 横扫所有节点的过程，看着就像是dfs的迭代写法，只是stack用了queue，
         * 这里取出顺序其实并没什么影响
         *
         */

//        List<String> res = new ArrayList<>();
//        if (n == 0) {
//            return res;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(new Node("", 0, 0));
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            Node curNode = queue.poll();
////            for (int i = 0; i < size; i++) {
//                if (curNode.left == n && curNode.right == n) {
//                    res.add(curNode.res);
//                }
//                if (curNode.left < n) {
//                    queue.offer(new Node(curNode.res + "(", curNode.left + 1, curNode.right));
//                }
//                if (curNode.left > curNode.right) {
//                    queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right + 1));
//                }
////            }
//        }
//        return res;


        /**
         * 这个应该才是真正的bfs
         */
//        Deque<String> strQ = new LinkedList<>();
//        Deque<Integer> leftQ = new LinkedList<>();
//        Deque<Integer> rightQ = new LinkedList<>();
//        strQ.offer("");
//        leftQ.offer(0);
//        rightQ.offer(0);
//        //下面两种终止条件判断都可以
//        while (leftQ.peek() + rightQ.peek() < 2 * n) {
////        while (strQ.peek().length() < 2 * n) {
//            int size = strQ.size();
//            while (size-- > 0) {
//                String cur = strQ.poll();
//                int left = leftQ.poll();
//                int right = rightQ.poll();
//                if (left < n) {
//                    strQ.offer(cur + "(");
//                    leftQ.offer(left + 1);
//                    rightQ.offer(right);
//                }
//                if (right < left) {
//                    strQ.offer(cur + ")");
//                    leftQ.offer(left);
//                    rightQ.offer(right + 1);
//                }
//
//            }
//        }
//        /**
//         * 因为这种情况下会每层去加括号并且会把上一层的取出来，
//         * 最后得到的queue就是最后一层的括号值
//         */
//        return (List<String>) strQ;





//        List<String> result = new LinkedList<>();
//
//        //第一层初始应该是空串，因为出口判断条件不一样，因此max也不一样
//        recur1(0, 0, n, result, "");
////        recur(0,2 * 3, result, "");
//
//
//        return result;
    }

          private void dfsChars(int left, int right, int i, int n, List<String> res, char[] chars) {

              //curr.length一定是2*n,不能用curr.length==2*n
              if (chars.length == i) {
                  res.add(new String(chars));
                  return;
              }

              if (left < n) {
                  chars[i] = '(';
                  dfsChars(left + 1, right, i + 1, n, res, chars);
              }

              if (right < left) {
                  chars[i] = ')';
                  dfsChars(left, right + 1, i + 1, n, res, chars);
              }

          }


          private void dfs(int left, int right, int max, List<String> res, String s) {

              if (s.length() == max * 2) {
                  res.add(s);
                  return;
              }

              //当前层逻辑
              if (left < max) {
                  dfs(left + 1, right, max, res, s+"(");
              }

              if (right < left) {
                  dfs(left, right + 1, max, res, s+")");
              }




          }


          private void recur2(int left, int right, int n, List<String> res, String s) {

              //结束条件
              if (left == n && right == n) {
                  res.add(s);
                  return;
              }

              //当前逻辑
              //进入下一层，加上条件剪枝
              if (left<n) recur2(left + 1, right, n, res, s + "(");
              if (right<left) recur2(left, right + 1, n, res, s + ")");

              //重置状态，一般回溯会用到，这个不用



          }

          public void recur(int deep,int max,List<String> result,String str){


        if (deep == max) {
            result.add(str);
            System.out.println(str);
            return;
        }

        //current logic

        //drop down
        /**
         * 这儿对应递归两种可能，左分支和右分支
         */
        recur(deep + 1, max, result, str+ "(");
        recur(deep + 1, max, result, str+ ")");


    }


          /**
           * 条件判断可以直接在递归过程中判断，
           * 1、左括号可以随便加，只要不超过做大限制即可
           * 2、右括号必须在有左括号的时候才能加，右括号<左括号
           */
    public void recur1(int left, int right, int max, List<String> result, String str) {

        if (left == max && right == max) {
//        if (str.length() == max * 2) {
            result.add(str);
            System.out.println(str);
            return;
        }

        //current logic

        //drop down
        /**
         * 这儿对应递归两种可能，左分支和右分支
         * 可以加些条件进行剪枝
         */
        if (left < max)
            recur1(left + 1, right, max, result, str + "(");
        if (right < left)
            recur1(left, right + 1, max, result, str + ")");


    }

          class Node {
              /**
               * 当前得到的字符串
               */
              private String res;
              /**
               * 剩余左括号数量
               */
              private int left;
              /**
               * 剩余右括号数量
               */
              private int right;

              public Node(String str, int left, int right) {
                  this.res = str;
                  this.left = left;
                  this.right = right;
              }
          }



      }
//leetcode submit region end(Prohibit modification and deletion)

  }