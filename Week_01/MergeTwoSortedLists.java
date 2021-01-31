//题号：21
//https://leetcode-cn.com/problems/merge-two-sorted-lists/
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1506 👎 0



public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        /**
         * 递归
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

//            if (l1 == null) {
//                return l2;
//            }
//
//            if (l2 == null) {
//                return l1;
//            }
//
//            //不要试图去人肉递归，只要记住，mergeTwoLists(x,y)这个函数给出的是排好序的
//            //合并链表，我们只需要将小的链表的下一个节点指向它即可。
//            if (l1.val <= l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }

            /**
             * 法一：递归法，时间复杂度O(n)，空间复杂度O(n)
             */

//            if (l1 == null) {
//                return l2;
//            }
//
//            if (l2 == null) {
//                return l1;
//            }
//
//            //不要试图去人肉递归，只要记住，mergeTwoLists(x,y)这个函数给出的是排好序的
//            //合并链表，我们只需要将小的链表的下一个节点指向它即可。
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }

            /**
             * 非递归，迭代法,
             */


            ListNode result = new ListNode();
            ListNode pre = result;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }

                pre = pre.next;

            }

            pre.next = l1 == null ? l2 : l1;

            return result.next;

        }

        /**
         * 非递归
         */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        //这个类似哑结点
//        ListNode result = new ListNode();
//
//        //因为这里的pre会一直被替换为pre.next，因此需要个其他变量
//        //否則result会找不到一开始的位置
//        ListNode pre = result;
//
//        while (l1 != null && l2 != null) {
//            //比较大小，直接将pre指向小的那个链表，然后将相应链表指针后移
//            if (l1.val <= l2.val) {
//                pre.next = l1;
//                l1 = l1.next;
//            } else {
//                pre.next = l2;
//                l2 = l2.next;
//            }
//            //pre里面增加了一个元素，因此要将指针后移
//            pre = pre.next;
//        }
//
//        //这是一边链表比另一边长的时候，直接将长的部分放到pre后面即可
//        pre.next = l1 == null ? l2 : l1;
//
//        return result.next;
//    }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        MergeTwoSortedLists.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MergeTwoSortedLists.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}