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


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
      public static void main(String[] args) {
          Solution solution = new GenerateParentheses().new Solution();
          solution.generateParenthesis(3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

//        List<String> res = new ArrayList<>();
//        recur2(0, 0, n, res, "");
//
//        return res;

        /**
         * dfs
         */

//        List<String> res = new ArrayList<>();
//        dfs(0, 0, n, res, "");
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
        Deque<String> strQ = new LinkedList<>();
        Deque<Integer> leftQ = new LinkedList<>();
        Deque<Integer> rightQ = new LinkedList<>();

        strQ.offer("");
        leftQ.offer(0);
        rightQ.offer(0);

        //下面两种终止条件判断都可以
        while (leftQ.peek() + rightQ.peek() < 2 * n) {
//        while (strQ.peek().length() < 2 * n) {
            int size = strQ.size();
            while (size-- > 0) {
                String cur = strQ.poll();
                int left = leftQ.poll();
                int right = rightQ.poll();
                if (left < n) {

                    strQ.offer(cur + "(");
                    leftQ.offer(left + 1);
                    rightQ.offer(right);
                }

                if (right < left) {
                    strQ.offer(cur + ")");
                    leftQ.offer(left);
                    rightQ.offer(right + 1);
                }

            }
        }
        /**
         * 因为这种情况下会每层去加括号并且会把上一层的取出来，
         * 最后得到的queue就是最后一层的括号值
         */
        return (List<String>) strQ;





//        List<String> result = new LinkedList<>();
//
//        //第一层初始应该是空串，因为出口判断条件不一样，因此max也不一样
//        recur1(0, 0, n, result, "");
////        recur(0,2 * 3, result, "");
//
//
//        return result;
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