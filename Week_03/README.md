学习笔记

##### 本周总结

这周学习了递归，了解了递归的模板方法如下：

- 找到终止条件
- 当前层逻辑
- 进入下一层
- 状态重置  

套用这个模板递归看着没有以前那么难了，但是对于一个函数，是可以在本身函数
直接递归还是需要新写一个函数递归，这个我还是感觉很疑惑。

另外递归写多了发现树这种结构，好像天生适合递归，前中后序遍历，DFS都可以用递归
实现。

递归这种逻辑有两个算法实现：分治和回溯。

*分治*采用的是分而治之的思想，将一个大问题不断拆分成一个个子问题，直到子问题可以直接
得出答案，然后再将这些子问题答案组装起来，得到最终答案。这种思想在现在的生活中
很常见，比如著名的map-reduce就是这个思想。

*回溯*，我理解就是利用递归，不断的去尝试所有可能的解法，知道找到想要的解法，没有任何
条件约束的傻回溯，时间复杂度是非常高的，好像是O(2^n)，但是我们可以通过一些条件约束
进行剪枝，这样其实效率会高很多，和正常迭代差不多。

春节两周完成一周课程，这周作业时间比较充裕，感觉比前两周好点。

