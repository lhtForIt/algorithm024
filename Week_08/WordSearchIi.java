//题号：212
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 350 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordSearchIi {
      public static void main(String[] args) {
           Solution solution = new WordSearchIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public List<String> findWords(char[][] board, String[] words) {


              /**
               * 直接DFS，超时
               */
//              int m = board.length;
//              int n = board[0].length;
//
//              Set<String> res = new HashSet<>();
//              if (board.length==0 || board[0].length==0 || words.length==0) {
//                  return new ArrayList<>(res);
//              }
//
//              for (String word : words) {
//                  // 在循环内定义visited，重启上一个word对visited改变
//                  boolean[][] visited = new boolean[m][n];
//                  for (int i = 0; i < m; i++) {
//                      for (int j = 0; j < n; j++) {
//                          // word已经被存到结果中，continue
//                          if (res.contains(word)) continue;
//                          // word长度为1，直接和board中字符匹配
//                          if (word.length()==1) {
//                              String s = String.valueOf(board[i][j]);
//                              if (word.equals(s)) {
//                                  res.add(word);
//                                  continue;
//                              }
//                          }
//                          // word首字母与board中字符相同时，进入dfs
//                          if (board[i][j]==word.charAt(0)) {
//                              visited[i][j] = true;
//                              dfs(board, res, visited, i, j, word, 0);
//                              visited[i][j] = false;
//                          }
//                      }
//                  }
//              }
//              return new ArrayList<>(res);

              /**
               * 用Trie对dfs进行剪枝
               */

              List<String> res = new ArrayList<>();
              TrieNode root = buildTrie(words);
              for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board[0].length; j++) {
                      dfsWithTrie(board, i, j, root, res);
                  }
              }
              return res;



          }

          private void dfsWithTrie(char[][] board, int i, int j, TrieNode p, List<String> res) {
              char c = board[i][j];
              if (c == '#' || p.next[c - 'a'] == null) return;
              p = p.next[c - 'a'];
              if (p.word != null) {   // found one
                  res.add(p.word);
                  p.word = null;     // de-duplicate
              }

              board[i][j] = '#';
              //这儿可以用二维数组表示方向
              if (i > 0) dfsWithTrie(board, i - 1, j ,p, res);
              if (j > 0) dfsWithTrie(board, i, j - 1, p, res);
              if (i < board.length - 1) dfsWithTrie(board, i + 1, j, p, res);
              if (j < board[0].length - 1) dfsWithTrie(board, i, j + 1, p, res);
              board[i][j] = c;
          }

          private TrieNode buildTrie(String[] words) {
              TrieNode root = new TrieNode();
              for (String w : words) {
                  TrieNode p = root;
                  for (char c : w.toCharArray()) {
                      int i = c - 'a';
                      if (p.next[i] == null) p.next[i] = new TrieNode();
                      p = p.next[i];
                  }
                  p.word = w;
              }
              return root;
          }

          class TrieNode {
              TrieNode[] next = new TrieNode[26];
              String word;
          }



          private void dfs(char[][] board, Set<String> res, boolean[][] visited, int i, int j, String word, int pos) {
              if (board[i][j] != word.charAt(pos)) return;
              // pos 与 word 长度相同，说明已经找到了
              if ((pos+1)==word.length()) {
                  res.add(word);
                  return;
              }
              // 方向搜索二维数组
              int [][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
              for (int [] dir : direction) {
                  int newi = i + dir[0], newj = j + dir[1];
                  if (newi>-1 && newj>-1 && newi<board.length && newj<board[0].length && !visited[newi][newj]) {
                      visited[newi][newj] = true;
                      dfs(board,res,visited,newi,newj,word,pos+1);
                      visited[newi][newj] = false;
                  }
              }

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }