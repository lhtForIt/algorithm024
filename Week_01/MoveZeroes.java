//题号：283
//https://leetcode-cn.com/problems/move-zeroes/
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 935 👎 0


public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{1,0, 3, 0, 12});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {


            /**
             * 法一：两次循环
             */


//              if (nums == null) {
//                  return;
//              }
//
//              int j = 0;
//              for (int i = 0; i < nums.length; i++) {
//                  if (nums[i]!=0) {
//                      nums[j++] = nums[i];
//                  }
//              }
//
//              //前面有j个非0的，因为下标从0开始，因此其实位置刚好是j
//              for (int i = j; i < nums.length; i++) {
//                  nums[i] = 0;
//              }


            /**
             * 法二：双指针
             */


            if (nums == null) {
                return;
            }

            //因为非0数据要保持原先位置，因此需要用非0的与0替换
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                //因为i,j起点一样，当nums[i]不等于0，j会加1，因此j一定是在0的位置
                if (nums[i] != 0) {
                    //只有不同位置才需要交换
                    if (i != j) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                    j++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}