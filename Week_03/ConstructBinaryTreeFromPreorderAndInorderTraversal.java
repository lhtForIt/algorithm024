//题号：105
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 878 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /**
         * 递归
         * 时间复杂度O(n)，空间复杂度O(n)
         */

//        int n = preorder.length;
//        //利用map存储节点位置，以方便我们快速查找
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//
//        return recur(preorder, inorder, 0, n - 1, 0, n - 1);

        /**
         * 迭代
         * 时间复杂度O(n)，空间复杂度O(n)
         */

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int inOrderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {

            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inOrderIndex]) {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]) {
                    node = stack.pop();
                    inOrderIndex++;
                }

                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }

        return root;


    }

    private TreeNode recur(int[] preOrder, int[] inOrder, int preOrder_left, int preOrder_right, int inOrder_left, int inOrder_right) {

        // preOrder 为空，直接返回 null
        if (preOrder_left > preOrder_right) {
            return null;
        }

        int preOrder_root = preOrder_left;
        int inOrder_root = indexMap.get(preOrder[preOrder_root]);


        //根节点
        TreeNode root = new TreeNode(preOrder[preOrder_root]);
        //左子树中节点数目
        int subLeft = inOrder_root - inOrder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 subLeft」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = recur(preOrder, inOrder, preOrder_left + 1, preOrder_left + subLeft, inOrder_left, inOrder_root - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = recur(preOrder, inOrder, preOrder_left + subLeft + 1, preOrder_right, inOrder_root + 1, inOrder_right);

        return root;
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