//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 882 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

        /**
         * 时间复杂度O(nlogn),空间复杂度O(logn)
         */

//        if (intervals.length == 0) {
//            return new int[0][2];
//        }
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
//        List<int[]> merged = new ArrayList<int[]>();
//        for (int i = 0; i < intervals.length; ++i) {
//            int L = intervals[i][0], R = intervals[i][1];
//            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                merged.add(new int[]{L, R});
//            } else {
//                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);


        /**
         * 时间复杂度O(nlogn),空间复杂度O(logn)
         *
         * 对二维数组sort和将二维数组变成两个一维数组在sort时间差别这么大么？
         *
         */
        int length=intervals.length;
        if(length<=1)
            return intervals;

        int[] start = new int[length];
        int[] end = new int[length];
        for(int i=0;i<length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex=0;
        int endIndex=0;
        List<int[]> result = new LinkedList<>();
        while(endIndex<length){
            //as endIndex==length-1 is evaluated first, start[endIndex+1] will never hit out of index
            if(endIndex==length-1 || start[endIndex+1]>end[endIndex]){
                result.add(new int[]{start[startIndex],end[endIndex]});
                startIndex=endIndex+1;
            }
            endIndex++;
        }
        return result.toArray(new int[result.size()][]);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}