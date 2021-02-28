#### 学习笔记

##### 广度优先搜索和深度优先搜索

以遍历树为例子：

- 深度优先搜索（DFS）：从树的根出发，随机访问左右节点，然后一直向下遍历，直到没有叶子结点，再返回根，重复上述过程。
- 广度优先遍历（BFS）：从树的根出发，像水波纹一样，遍历每一层的节点，再依次到下一层。(求树的最小深度，最短路等常用)。

这两种搜索算法是常考点，例题有很多，每道题基本都有BFS和DFS两种解法，有的还是bfs+dfs共用，以及双端BFS等，单词接龙那两道题困难的题，我这会还有点似懂非懂的样子，总的说来东西还是不少的，感觉掌握的不是很牢固，只有五毒神掌慢慢消化了。

##### 贪心算法

贪心算法我其实感觉单独用的不多，多用于和动态规划比较，因为**贪心算法的要求是每一阶段都达到最优**，这个实际很难达到，但是也如视频说的，只要达到了，代码其实相对简单，理解起来没多大难度。

##### 二分查找

二分查找对数据有三个要求：

1. 单调性（递增或者递减）
2. 边界（有限的，能确定左右指针边界）
3. 能通过下标快速访问(一般是数组，链表如果是跳表也可以)

```
public int binarySearch(int[] nums,int target){
    int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid] >target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
}

```

二分查找会有一种变形题，即有序数组被旋转之后要找某个值，可以按照如下方法求解：

```
public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                //0到mid有序,且target大于有序部分最大值或者小于最小值，target在另一半里，left=mid+1
                if (nums[0] <= nums[mid] && (nums[mid] < target || target < nums[0])) {
                    left = mid + 1;
                } else if (target > nums[mid] && target < nums[0]) {//这儿0到mid有旋转，判断升序部分，target > nums[mid] && target < nums[0]满足这个条件target在另一部分
                    left = mid + 1;
                } else {
                    right = mid;//否则在前半部分
                }
            }
            //这儿left==right
            return left == right && nums[left] == target ? left : -1;
}
```

这种题在解的时候其实相当于把二分的概念扩大了，不止找数的时候二分，还要找到有序的空间，我们始终是在有序的空间里面找到对应的target值，当排除到只剩最后一个元素时，退出循环，然后拿该数和target比较即可。

对于下面这个题：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

思路如下，我们要找到无序的地方，其实直接找无序的片段，不断在无序片段里用二分查找比较mid和mid+1的值，当nums[mid]>nums[mid+1]时，mid+1就是无序的位置，这里需要注意判断mid+1是否越界，**这个思路也适用于找旋转数组最大值**。

```
public int search1(int[] nums) {

            int left = 0, right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                } else if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }



            return left;
        }
```

