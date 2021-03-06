学习笔记

#### 剪枝

剪枝，我理解就是我们每次递归或者回溯都会有相应的递归树，递归的路径其实就是树的枝叶，在实际情况中其实有很多“枝叶”是不符合条件的，我们完全没有必要走下去，这时候我们就可以根据适当的条件把这些枝叶减掉，从而减少了递归场景，节省了时间，就和现实生活中的剪枝一样。

**剪枝**这个概念其实在递归那章就会用到，或者说我们在做正常的递归或者dfs求解都会用到，不然实实在在的傻递归复杂度就太高了。

#### 双向BFS

双向BFS会比单向bfs快很多，而且是随着你遍历的层级越远，差别越明显，因为单向BFS会随着你遍历的直线距离越远遍历的范围会越大，元素也会越多，而双向BFS则会用两个起点同时往中间扩散，当两个在中间相遇，就是我们要遍历的结果，而且它会优先从节点少的端点遍历，这样能进一步提高速度。

双向BFS模板：

```java
Set start=new HashSet();
Set end=new HashSet();
start.add(start);
end.add(end);

while(!start.isEmpty&&!end.isEmpty){
    //始终保证从最小的一端搜索
    if(start.size()<end.size()){
        Set temp=start;
        start=end;
        end=temp;
    }
    
    Set set=new HashSet();
    
    //退出条件
    if(end.contain(node)){
        return ;
    }
    
    //执行当前逻辑
    
    //将元素加到起始端，并进行下一次搜索
    set.add(node);
    start=set;
    
}

```



#### 启发式搜索(A*)

启发式搜索(A*)搜索这个其实没太听懂，这是大致了解是通过某种制定的规律去搜索，存储的容器也由queue变成了优先级队列，我们会根据事先制定好的优先级函数从队列里面拿。

这个面试的时候好像考的不多，有这个概念就行，以后用到再研究吧。先巩固前面的知识点。