//题号：126
//https://leetcode-cn.com/problems/word-ladder-ii/description/
//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 398 👎 0


import java.util.*;

public class WordLadderIi {
      public static void main(String[] args) {
           Solution solution = new WordLadderIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        /**
         * BFS+DFS
         *
         *
         */
//        List<List<String>> res = new ArrayList<>();
//        if (!wordList.contains(endWord)) {
//            return res;
//        }
//        HashSet<String> dict = new HashSet<>(wordList);
//
//        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
//        HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
//
//        ArrayList<String> solution = new ArrayList<>();
//
//        dict.add(beginWord);
//        bfd(beginWord,endWord,dict,nodeNeighbors,distance);
//        dfs(beginWord,endWord,dict,nodeNeighbors,distance,solution,res);
//
//        return res;

        /**
         * 双向BFS+dfs
         */
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);
        HashMap<String, List<String>> map = new HashMap<>();
        bfs1(map, set1, set2, dict, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs1(res, path, map, beginWord, endWord);
        return res;
        
        
        
        
    }

          private void dfs1(List<List<String>> res, List<String> path, HashMap<String, List<String>> map, String start, String end){
              if(start.equals(end)){
                  res.add(new ArrayList<>(path));
                  return;
              }

              if(!map.containsKey(start)){
                  return;
              }

              for(String next : map.get(start)){
                  path.add(next);
                  dfs1(res, path, map, next, end);
                  path.remove(path.size() - 1);
              }
          }

          private void bfs1(HashMap<String, List<String>> map, HashSet<String> set1, HashSet<String> set2, HashSet<String> dict, boolean flip){
              if(set1.isEmpty()){
                  return;
              }

              if(set1.size() > set2.size()){
                  bfs1(map, set2, set1, dict, !flip);
                  return;
              }

              boolean done = false;
              dict.removeAll(set1);
              dict.removeAll(set2);

              HashSet<String> next = new HashSet<>();
              for(String str : set1){
                  char[] chs = str.toCharArray();
                  for(int i = 0; i < chs.length; i++){
                      char temp = chs[i];
                      for(char ch = 'a'; ch <= 'z'; ch++){
                          if(chs[i] != ch){
                              chs[i] = ch;
                              String word = new String(chs);

                              String key = flip ? word : str;
                              String val = flip ? str : word;

                              List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);

                              if(set2.contains(word)){
                                  done = true;

                                  list.add(val);
                                  map.put(key, list);
                              }

                              if(!done && dict.contains(word)){
                                  next.add(word);

                                  list.add(val);
                                  map.put(key, list);
                              }
                          }
                      }
                      chs[i] = temp;
                  }
              }

              if(!done){
                  bfs1(map, set2, next, dict, !flip);
              }
          }

          private void bfd(String beginWord, String endWord, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
              for (String str : dict) {
                  nodeNeighbors.put(str, new ArrayList<>());
              }

              Deque<String> queue = new LinkedList<>();
              queue.offer(beginWord);
              distance.put(beginWord, 0);

              while (!queue.isEmpty()) {

                  int count = queue.size();
                  boolean foundEnd = false;

                  for (int i = 0; i < count; i++) {
                      String cur = queue.poll();
                      int curDistance = distance.get(cur);
                      ArrayList<String> neighbors = getNeighbors(cur, dict);


                      for (String neighbor : neighbors) {
                          nodeNeighbors.get(cur).add(neighbor);
                          if (!distance.containsKey(neighbor)) {// Check if visited
                              distance.put(neighbor, curDistance + 1);
                              if (endWord.equals(neighbor))// Found the shortest path
                                  foundEnd = true;
                              else
                                  queue.offer(neighbor);
                          }
                      }
                  }
                  if (foundEnd)
                      break;

              }

          }

          private ArrayList<String> getNeighbors(String node, Set<String> dict) {

              ArrayList<String> res = new ArrayList<>();
              char chs[] = node.toCharArray();

              for (char ch ='a'; ch <= 'z'; ch++) {
                  for (int i = 0; i < chs.length; i++) {
                      if (chs[i] == ch) continue;
                      char old_ch = chs[i];
                      chs[i] = ch;
                      if (dict.contains(String.valueOf(chs))) {
                          res.add(String.valueOf(chs));
                      }
                      chs[i] = old_ch;
                  }

              }
              return res;





          }

          // DFS: output all paths with the shortest distance.
          private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
              solution.add(cur);
              if (end.equals(cur)) {
                  res.add(new ArrayList<>(solution));
              } else {
                  for (String next : nodeNeighbors.get(cur)) {
                      if (distance.get(next) == distance.get(cur) + 1) {
                          dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                      }
                  }
              }
              solution.remove(solution.size() - 1);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }