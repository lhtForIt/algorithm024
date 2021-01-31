学习笔记
##### Queue

Queue是一个接口，而Stack是一个类，由此可以看出Queue的实现和运用场景很多，因此抽象成了接口。

盲猜Stack在实际生活中运用的比较少，从Java Deque API建议用Deque而不是Stack也可以看出来。

Queue的实现多种多样，大致分为两类，一个是数组，一个是链表。

Queue多与并发一起使用，大部分操作都会涉及到锁的使用，名字里带有BlockingQueue的都是线程安全的实现。

add(e),offer(e)会将元素加入到数组/链表，在加入之前会判断数组是否达到最大值，如果达到，会进行动态扩容。（这个不同实现好像不一样，ArrayBlockingQueue好像不会扩容，ArrayDeque会扩容）

remove(),poll()会将队列尾部元素取出，并将其从队列里删除。

element(),peek()会将队列尾部元素取出，但是不会从队列删除。

##### PriorityQueue

PriorityQueue是一种特殊的队列，它插入的时候会按照一定的顺序排序，因此它的插入操作时间复杂度是O(logn)**（视频里说的是O（1）？）**，取出操作是O(logn)。

插入：add(E e),offer(E e)，add()其实也是调用的offer()，插入先判断数组是否有空余位置，如果没有则进行扩容。插入时会根据传入的Comparator进行排序之后插入，因此我感觉是O(logn)而不是O(1)，如果没有传Comparator则采用默认的排序方式进行排序。

取出：removeEq(Object o),remove(Object),removeAt(int i),这几个方法最后都会调用removeAt,因此我们只需要看removeAt即可。removeAt支持从指定位置取出元素，取出之后会对元素重新排序。


#### 本周独白

本来想着把有空的话把栈和队列分别用数组和链表实现一遍，自己过一下这些内容的，
但是发现严重高估自己了，刷五毒神掌的题和做本周作业就没时间了，周末两天好像有点不够用的样子，
不知道是自己效率低还是没适应这种强度？

希望下周进度会好点，加油！！
