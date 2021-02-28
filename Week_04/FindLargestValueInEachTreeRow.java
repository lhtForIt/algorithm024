//题号：515
//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 125 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow {
      public static void main(String[] args) {
           Solution solution = new FindLargestValueInEachTreeRow().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        /**
         * 一开始想到的应该是BFS
         * 时间复杂度O(n)，空间复杂度O(n)，树的深度
         */

//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int max = Integer.MIN_VALUE;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                max = Math.max(max, node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            res.add(max);
//        }
//
//        return res;

        /**
         * DFS
         */


        List<Integer> res = new ArrayList<>();

//        if (root == null) {
//            return res;
//        }

        //也是傻，没必要用个map去装，直接在res里面操作就行
//        Map<Integer, Integer> levelMaxMap = new TreeMap<>();
//        dfs(1, res, root, levelMaxMap);
//
//        for (Integer i : levelMaxMap.keySet()) {
//            res.add(levelMaxMap.get(i));
//        }

        dfsOpt(0, res, root);


        return res;



    }

    private void dfsOpt(int level, List<Integer> res, TreeNode node) {

        if (node == null) {
            return;
        }

        //当前层逻辑
        //递归是从浅到深，因此第一条路遍历完会将res初始化完
        if (res.size() == level) {
            res.add(node.val);
        } else {
            //习惯写成了add(index,element)这种，它会在index位置加入一个元素，而不是替代，找了好久原因
//            res.add(level, Math.max(res.get(level), node.val));
            res.set(level, Math.max(res.get(level), node.val));
        }

        //下探
        //这里的!=null其实也相当于终止条件了，正常模板下探前没有！=null判断，
        // 然后是在递归开始判断if(node==null) return；这里其实没什么区别，就是不进下一层和进下一层直接退出而已
//        if (node.left != null) {
            dfsOpt(level + 1, res, node.left);
//        }

//        if (node.right != null) {
            dfsOpt(level + 1, res, node.right);
//        }



    }

    private void dfs(int level, List<Integer> res, TreeNode node, Map<Integer, Integer> levelMaxMap) {



        //当前层逻辑
        int maxLevel = levelMaxMap.getOrDefault(level, Integer.MIN_VALUE);
        levelMaxMap.put(level, Math.max(node.val, maxLevel));

        //这儿的!=null其实也是终止条件
        if (node.left != null) {
            dfs(level + 1, res, node.left, levelMaxMap);
        }

        if (node.right != null) {
            dfs(level + 1, res, node.right, levelMaxMap);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  }