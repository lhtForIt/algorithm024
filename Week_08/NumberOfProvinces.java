//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 524 👎 0

public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        /**
         * 并查集
         * 是不是所有并查集能解的题都能用dfs和bfs解？
         */
        int n = isConnected.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // 返回最终合并后的集合的数量
        return uf.count;
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
}
//leetcode submit region end(Prohibit modification and deletion)

}