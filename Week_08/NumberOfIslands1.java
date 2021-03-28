//题号：200
//https://leetcode-cn.com/problems/number-of-islands/
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 995 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands1 {
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands1().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {


        /**
         * 并查集
         */

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        UnionFind uf = new UnionFind(m * n);
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    count++;
                } else {
                    //只往右下判断即可
//                    if(i>0&&grid[i-1][j]=='1')uf.union(i*n+j,(i-1)*n+j);
//                    if(i<m-1&&grid[i+1][j]=='1') uf.union(i*n+j,(i+1)*n+j);
//                    if(j>0&&grid[i][j-1]=='1') uf.union(i*n+j,i*n+j-1);
//                    if(j<n-1&&grid[i][j+1]=='1') uf.union(i*n+j,i*n+j+1);

                    // 这儿用一个数组变量代表方向
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 先判断坐标合法，再检查右边一格和下边一格是否是陆地
                        if (newX < m && newY < n && grid[newX][newY] == '1') {
                            uf.union(i * n + j, newX * n + newY);
                        }
                    }
                }

            }
        }

        return uf.count - count;



        /**
         * dfs O(n^2)
         */
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//
//        return count;
        /**
         * BFS
         */

//        int count = 0;
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j] == '1'){
//                    bfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//        return count;


    }




          class UnionFind {

              private int count = 0;
              private int[] parent;

              public UnionFind(int n) {
                  count = n;
                  parent = new int[n];
                  for (int i = 0; i < n; i++) {
                      parent[i] = i;
                  }
              }

              public int find(int p) {
                  while (p != parent[p]) {
                      parent[p] = parent[parent[p]];
                      p = parent[p];
                  }
                  return p;
              }


              public void union(int p, int q) {
                  int rootP = find(p);
                  int rootQ = find(q);
                  if (rootP == rootQ) return;
                  parent[rootP] = rootQ;
                  count--;
              }

          }







          private void bfs(char[][] grid, int i, int j) {

              Queue<int[]> queue = new LinkedList<>();
              queue.add(new int[] { i, j });

              while(!queue.isEmpty()){
//                  int size = queue.size();
//                  for (int k = 0; k < size; k++) {
                      int[] cur = queue.remove();
                      i = cur[0]; j = cur[1];
                      if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                          grid[i][j] = '0';
                          queue.add(new int[] { i + 1, j });
                          queue.add(new int[] { i - 1, j });
                          queue.add(new int[] { i, j + 1 });
                          queue.add(new int[] { i, j - 1 });
                      }
//                  }
              }

          }

          private void dfs(char[][] grid, int i, int j) {
              if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
              grid[i][j] = '0';
              dfs(grid, i + 1, j);
              dfs(grid, i, j + 1);
              dfs(grid, i - 1, j);
              dfs(grid, i, j - 1);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }