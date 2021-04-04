//题号：1122
//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 165 👎 0


public class RelativeSortArray {
      public static void main(String[] args) {
           Solution solution = new RelativeSortArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int[] relativeSortArray(int[] arr1, int[] arr2) {

              int[] count = new int[10001];

              for (int n : arr1) count[n]++;

              int i = 0;
              for (int n : arr2) {
                  while (count[n]-- > 0) {
                      arr1[i++] = n;
                  }
              }


              for (int j = 0; j < count.length; j++) {
                  while (count[j]-- > 0) {
                      arr1[i++] = j;
                  }
              }

              return arr1;







              /**
               * 计数排序
               *
               * 计数排序用数组天然有顺序，而map在arr2拿完数之后还需要排序，
               * 可以用treeMap进行自动排序，但会牺牲一定的性能
               *
               */
//              int[] cnt = new int[1001];
//              //计数arr1出现的次数
//              for(int n : arr1) cnt[n]++;
//              int i = 0;
//              //将arr2的值输出到arr1
//              for(int n : arr2) {
//                  while(cnt[n]-- > 0) {
//                      arr1[i++] = n;
//                  }
//              }
//              //将剩余arr1的值输出，因为是升序遍历，因此出来的数也是升序,这里直接从头遍历感觉不是很好，想想是否能优化
//              for(int n = 0; n < cnt.length; n++) {
//                  while(cnt[n]-- > 0) {
//                      arr1[i++] = n;
//                  }
//              }
//              return arr1;

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }