//题号：433
//
//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意： 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 
//
// 示例 1： 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2： 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3： 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 67 👎 0


import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
           Solution solution = new MinimumGeneticMutation().new Solution();
        solution.minMutation(new String("AACCGGTT"), new String("AACCGGTA"), new String[]{"AACCGGTA"});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int minChange = Integer.MAX_VALUE;


    public int minMutation(String start, String end, String[] bank) {

        /**
         * BFS
         * m start长度，n bank长度
         * 时间复杂度O(n*m*4)=O(m*n)，空间复杂度O(3n+4)=O(n)
         */
        if (start.equals(end)) {
            return 0;
        }

        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level=0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //由于是数组，每层只有一个，所以当前层循环完，直接步数加1
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                //这里不是递归，又是顺序遍历，直接找到第一个就是最小的
                if (curr.equals(end)) {
                    return level;
                }

                char[] currArray = curr.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char old = currArray[j];
                    //分别在当前位改变'A','C','G','T'去基因库试
                    for (char c : charSet) {
                        currArray[j] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next)&&bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    //必须要恢复状态，不然下一次匹配可能符合条件的抓不到
                    currArray[j] = old;
                }
            }
            level++;
        }

        return -1;


        /**
         * DFS 数组存储访问结果
         * 一开始没看懂啥意思，
         * 思路其实是用运用数组的特性，直接在数组上面去标记是否访问，
         * 这里其实完全没必要转成二维数组，直接以为也没影响
         */

//        char[][] banks = new char[bank.length][8];
//        for (int i = 0; i < bank.length; i++) {
//            banks[i] = bank[i].toCharArray();
//        }
//
//        dfs(start.toCharArray(), end.toCharArray(), banks, 0);
//
//        return minChange == Integer.MAX_VALUE ? -1 : minChange;


        /**
         * 下面是我数组的改进方案
         */

//        dfsArray(0, start, end, bank);
//        return minChange == Integer.MAX_VALUE ? -1 : minChange;




        /**
         * DFS Set
         *
         * 思路，遍历bank，找到和当前字符串相差一个字符的字符串，
         * 然后将找到的字符串变为当前字符串，重复上述步骤即可
         *
         *
         */

//        dfs1(new HashSet<>(), 0, start, end, bank);
//        return minChange == Integer.MAX_VALUE ? -1 : minChange;


        /**
         * 将diff比较放到一个函数里面，但是内存消耗会变大
         */
//        recur(new HashSet<>(), 0, start, end, bank);
//        return minChange == Integer.MAX_VALUE ? -1 : minChange;

    }

          private void dfsArray(int level, String start, String end, String[] bank) {

              if (start.equals(end)) {
                  minChange = Math.min(level, minChange);
                  return;
              }

              for (int j = 0; j < bank.length; j++) {
                  //需要一个变量存储置空之前的值
                  String temp = bank[j];

                  //null不能放在后面去判断，因为会有拿temp.charAt(i)的操作
                  if (temp == null) {
                      continue;
                  }

                  int diff = 0;
                  for (int i = 0; i < bank[j].length(); i++) {
                      if (start.charAt(i) != temp.charAt(i)) {
                          if (++diff > 1) break;
                      }
                  }

                  if (diff == 1) {
                      bank[j] = null;
                      dfsArray(level + 1, temp, end, bank);
                      bank[j] = temp;
                  }


              }



          }

          private void recur(HashSet<String> visited, int level, String start, String end, String[] bank) {

              if (start.equals(end)) {
                  minChange = Math.min(minChange, level);
                  return;
              }

              for (String str : bank) {
                  if (validDiff(start, str) && !visited.contains(str)) {
                      visited.add(str);
                      recur(visited, level + 1, str, end, bank);
                      visited.remove(str);
                  }
              }



          }

          private boolean validDiff(String start, String str) {
              int diff = 0;
              for (int i = 0; i < str.length(); i++) {
                  if (start.charAt(i) != str.charAt(i)) {
                      if (++diff > 1) {
                          break;
                      }
                  }
              }
              return diff == 1 ? true : false;
          }

          //visited用来记录访问过的
          private void dfs1(HashSet<String> visited, int level, String start, String end, String[] bank) {
              //这里直接用的level来表示转换了几次
              if (start.equals(end)) {
                  minChange = Math.min(minChange, level);
                  return;
              }

              for (String str : bank) {
                  int diff = 0;
                  for (int i = 0; i < str.length(); i++) {
                      //比较每一位
                      if (start.charAt(i) != str.charAt(i)) {
                          diff++;
                          //每次只能改变一个字符，当dif>1直接跳过
                          if (diff > 1) {
                              break;
                          }
                      }
                  }
                  //只相差一位且没有被访问过
                  if (diff == 1 && !visited.contains(str)) {
                      visited.add(str);
                      dfs1(visited, level + 1, str, end, bank);
                      //这是set，无序的，写成下面这种有问题，只有list能这么写
//                      visited.remove(visited.size() - 1);
                      visited.remove(str);
                  }
              }
          }


          private void dfs(char[] start, char[] end, char[][] bank, int change) {

              if (Arrays.equals(start, end)) {
                  minChange = Math.min(minChange, change);
                  return;
              }

              for (int j = 0; j < bank.length; j++) {
                  char[] piece = bank[j];
                  // 已用过的片段
                  if (piece == null) {
                      continue;
                  }
                  // 获取基因库中不同为1的片段,作为改变一次后的新start
                  int diff = 0;
                  for (int i = 0; i < start.length; i++) {
                      if (start[i] != piece[i])
                          if(++diff>1) break;
                  }
                  if (diff == 1) {
                      // 置空,防止循环使用
                      bank[j] = null;
                      dfs(piece, end, bank, change + 1);
                      //重置状态
                      bank[j] = piece;
                  }
              }






          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }