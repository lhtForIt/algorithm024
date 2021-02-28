//题号：127
//https://leetcode-cn.com/problems/word-ladder/description/
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 705 👎 0


import java.util.*;

public class WordLadder {
      public static void main(String[] args) {
           Solution solution = new WordLadder().new Solution();
          solution.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int minLength = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        /**
         * dfs 超时，
         * 这个题其实和基因那道题很类似，区别就是数据规模大了很多，
         * 因此单纯用DFS直接遍历会超时
         *
         */
//        Set<String> visited = new HashSet<>();
//        dfs(0, beginWord, endWord, wordList,visited);
//
//        return minLength == Integer.MAX_VALUE ? 0 : minLength;


        /**
         * bfs+Set记录
         */

//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        Set<String> visited = new HashSet<>();
//        Deque<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        visited.add(beginWord);
//        int level = 0;
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            level++;
//            for (int i = 0; i < size; i++) {
//                String curr = queue.poll();
//                for (String str : wordList) {
//                    if (visited.contains(str)) {
//                        continue;
//                    }
//
//                    if (!canConvert(curr, str)) {
//                        continue;
//                    }
//
//                    if (str.equals(endWord)) {
//                        return level + 1;
//                    }
//
//                    visited.add(str);
//                    queue.offer(str);
//
//                }
//
//            }
//
//
//        }
//
//
//        return 0;

        /**
         * bfs+数组记录
         */

//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        boolean[] visited = new boolean[wordList.size()];
//        Deque<String> queue = new LinkedList<>();
//        int index = wordList.indexOf(beginWord);
//        if (index != -1) {
//            visited[index] = true;
//        }
//        queue.offer(beginWord);
//        int level = 0;
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            level++;
//            for (int i = 0; i < size; i++) {
//                String curr = queue.poll();
//                for (int j = 0; j < wordList.size(); j++) {
//                    String str = wordList.get(j);
//                    if (visited[j]) {
//                        continue;
//                    }
//
//                    if (!canConvert(curr, str)) {
//                        continue;
//                    }
//
//                    if (str.equals(endWord)) {
//                        return level + 1;
//                    }
//
//                    visited[j]=true;
//                    queue.offer(str);
//
//                }
//
//            }
//
//
//        }
//
//
//        return 0;

        /**
         * 双向BFS
         */

//        int end = wordList.indexOf(endWord);
//        if (end == -1) {
//            return 0;
//        }
//
//        wordList.add(beginWord);
//        int start = wordList.size() - 1;
//        Deque<Integer> queue1 = new LinkedList<>();
//        Deque<Integer> queue2 = new LinkedList<>();
//        Set<Integer> visited1 = new HashSet<>();
//        Set<Integer> visited2 = new HashSet<>();
//        queue1.offer(start);
//        queue2.offer(end);
//        visited1.add(start);
//        visited2.add(end);
//        int count = 0;
//
//        while (!queue2.isEmpty() && !queue1.isEmpty()) {
//            count++;
//            //从节点小的一端遍历，当queue1节点多与queue2交换
//            if (queue1.size() > queue2.size()) {
//                Deque<Integer> temp = queue1;
//                queue1 = queue2;
//                queue2 = temp;
//                Set<Integer> t = visited1;
//                visited1 = visited2;
//                visited2 = t;
//            }
//
//            int size = queue1.size();
//            while (size-- > 0) {
//                String s = wordList.get(queue1.poll());
//                for (int i = 0; i < wordList.size(); i++) {
//                    if (visited1.contains(i)) {
//                        continue;
//                    }
//                    if (!canConvert(s, wordList.get(i))) {
//                        continue;
//                    }
//                    if (visited2.contains(i)) {
//                        return count + 1;
//                    }
//                    visited1.add(i);
//                    queue1.offer(i);
//                }
//            }
//
//        }
//        return 0;

        /**
         * 双向BFS+单词转换优化
         */

//        int end = wordList.indexOf(endWord);
//        if (end == -1) {
//            return 0;
//        }
//
//        wordList.add(beginWord);
//        Deque<String> queue1 = new LinkedList<>();
//        Deque<String> queue2 = new LinkedList<>();
//        Set<String> visited1 = new HashSet<>();
//        Set<String> visited2 = new HashSet<>();
//        queue1.offer(beginWord);
//        queue2.offer(endWord);
//        visited1.add(beginWord);
//        visited2.add(endWord);
//
//        Set<String> allWordSet = new HashSet<>(wordList);
//
//        int count = 0;
//
//        while (!queue2.isEmpty() && !queue1.isEmpty()) {
//            count++;
//            //从节点小的一端遍历，当queue1节点多与queue2交换
//            if (queue1.size() > queue2.size()) {
//                Deque<String> temp = queue1;
//                queue1 = queue2;
//                queue2 = temp;
//                Set<String> t = visited1;
//                visited1 = visited2;
//                visited2 = t;
//            }
//
//            int size = queue1.size();
//            while (size-- > 0) {
//                String s = queue1.poll();
//                char[] chars = s.toCharArray();
//                //这儿不在和wordlist比，而是替换字符然后查看wordlist是否包含，不需要遍历整个字符串
//                for (int i = 0; i < s.length(); i++) {
//
//                    char old = chars[i];
//
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        chars[i] = c;
//                        String str = new String(chars);
//                        // 已经访问过了，跳过
//                        if (visited1.contains(str)) {
//                            continue;
//                        }
//                        // 两端遍历相遇，结束遍历，返回 count
//                        if (visited2.contains(str)) {
//                            return count + 1;
//                        }
//
//                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
//                        if (allWordSet.contains(str)) {
//                            queue1.offer(str);
//                            visited1.add(str);
//                        }
//                    }
//
//                    chars[i] = old;
//
//                }
//            }
//
//        }
//        return 0;


        /**
         * 全球站高赞双向BFS
         * 看着和一般的BFS不一样，没有用queue
         */

//        if (!wordList.contains(endWord)) {
//            return 0;
//        }
//
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        int len = 1;
//        HashSet<String> visited = new HashSet<>();
//
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//
//        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//            //始终让beginSet最小
//            if (beginSet.size() > endSet.size()) {
//                Set<String> set = beginSet;
//                beginSet = endSet;
//                endSet = set;
//            }
//
//            Set<String> temp = new HashSet<>();
//
//            for (String word : beginSet) {
//                char[] chs = word.toCharArray();
//                for (int i = 0; i < chs.length; i++) {
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        char old = chs[i];
//                        chs[i] = c;
//                        String target = new String(chs);
//                        if (endSet.contains(target)) {
//                            return len + 1;
//                        }
//
//                        if (!visited.contains(target) && wordSet.contains(target)) {
//                            temp.add(target);
//                            visited.add(target);
//                        }
//                        chs[i] = old;
//                    }
//                }
//            }
//
//            beginSet = temp;
//            len++;
//
//        }
//
//        return 0;


        /**
         * 全球站法二
         */
//        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()||!wordList.contains(endWord)) return 0;
//
//        Set<String> reached = new HashSet<>();
//        Set<String> wordDict = new HashSet<>(wordList);
//        reached.add(beginWord);
//        wordDict.add(endWord);
//        int distance = 1;
//        while (!reached.contains(endWord)) {
//            Set<String> toAdd = new HashSet<>();
//            for (String each : reached) {
//                for (int i = 0; i < each.length(); i++) {
//                    char[] chars = each.toCharArray();
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        chars[i] = ch;
//                        String word = new String(chars);
//                        if (wordDict.contains(word)) {
//                            toAdd.add(word);
//                            wordDict.remove(word);
//                        }
//                    }
//                }
//            }
//            distance++;
//            if (toAdd.size() == 0) return 0;
//            reached = toAdd;
//        }
//        return distance;

        /**
         * 全球站法三 2,3都是BFS
         */
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int length = 0;
        set.add(endWord);
        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) return length + 1;
                wordMatch(w, set, q);
            }
            length++;
        }
        return 0;



    }

          private void wordMatch(String w, Set<String> set, Queue<String> q) {
              for (int i = 0; i < w.length(); i++) {
                  char[] word = w.toCharArray();
                  for (int j = 0; j < 26; j++) {
                      char c = (char) ('a' + j);
                      if (word[i] == c) continue;
                      word[i] = c;
                      String s = String.valueOf(word);
                      if (set.contains(s)) {
                          set.remove(s);
                          q.offer(s);
                      }
                  }
              }
          }

          private boolean canConvert(String curr, String str) {

              if (curr.length() != str.length()) {
                  return false;
              }

              int diff = 0;
              for (int i = 0; i < curr.length(); i++) {
                  if (curr.charAt(i) != str.charAt(i)) {
                      if(++diff>1) return false;
                  }
              }

              return diff == 1;
          }

          private void dfs(int level, String beginWord, String endWord, List<String> wordList, Set<String> visited) {
              if (beginWord.equals(endWord)) {
                  minLength = Math.min(minLength, level+1);
                  return;
              }

              for (String str : wordList) {

                  int diff = 0;
                  for (int i = 0; i < str.length(); i++) {
                      //与单词库里每一个对比
                      if (beginWord.charAt(i) != str.charAt(i)) {
                          if (++diff > 1) break;
                      }
                  }

                  if (diff == 1 && !visited.contains(str)) {
                      visited.add(str);
                      dfs(level + 1, str, endWord, wordList, visited);
                      visited.remove(str);
                  }

              }


          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }