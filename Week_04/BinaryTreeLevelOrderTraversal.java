//题号：102
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 784 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
//          0,2,4,1,null,3,-1,5,1,null,6,null,8
          solution.levelOrder(new TreeNode(0, new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8)))));
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
    public List<List<Integer>> levelOrder(TreeNode root) {






        /**
         * 法一：直接BFS,得到每层的数量在遍历
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        List<List<Integer>> res = new ArrayList<>();
//        //root为空直接返回
//        if (root == null) {
//            return res;
//        }
//
//        //BFS是queue，DFS是stack
//        Deque<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            List<Integer> subRes = new ArrayList<>();
//
//            //拿到size其实就是将树分层，
//            //然后得到size对应的层级信息
//            for (int i = 0; i < size; i++) {
//
//                TreeNode node = queue.poll();
//                subRes.add(node.val);
//
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//
//            }
//
//            res.add(subRes);
//
//        }
//
//        return res;


        /**
         * 法二：BFS，不要size，新建一个队列装每层数据，遍历完之后再把队列赋值回去
         * 时间复杂度O(n)，空间复杂度O(n)
         */
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        //BFS是queue，DFS是stack
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> subRes = new ArrayList<>();

            Deque<TreeNode> tempQueue = new LinkedList<>();

            while(!queue.isEmpty()) {

                TreeNode node = queue.poll();
                subRes.add(node.val);

                if (node.left != null) {
                    tempQueue.offer(node.left);
                }

                if (node.right != null) {
                    tempQueue.offer(node.right);
                }

            }

            res.add(subRes);
            queue = tempQueue;

        }

        return res;


        /**
         * dfs
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        List<List<Integer>> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//
//        dfs(root, 0, res);
//
//
//        return res;




    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {


        /**
         * 这儿为啥没有出口啊？难道根据下探时的if判断可以直接找到出口？
         * 出口是node.left和node.right为空
         */

        //没遍历到新的一层，创建一个子list供装数据
        //为防止res.get(level)报空。因此必须要这一步
        if (res.size()==level) {
            res.add(new ArrayList<>());
        }

        //当前层逻辑
        res.get(level).add(node.val);

        //下探到下一层
        if (node.left != null) {
            dfs(node.left, level + 1, res);
        }

        if (node.right != null) {
            dfs(node.right, level + 1, res);
        }

        //重置状态，这里没有状态改变，所以不用

    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
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