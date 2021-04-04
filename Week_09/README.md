##学习笔记
##### 布隆过滤器和LRU Cache

布隆过滤器一般会和哈希表一起拿来比较，哈希表会将数据value通过hash函数映射之后准确的存储起来，这样其实会占用一定的内存。在实际工业应用中，我们其实不需要准确的指导存储的内容，而只需要知道这个东西是有还是没有这两个状态即可，而在这种场景下Bloom Filter就应运而生。

**Bloom Filter**是一个很长的二进制向量和一系列随机映射函数。它可以用于检测一个函数是否在一个集合中。

- 优点：空间效率和查询时间都远远超过一半算法
- 缺点：有一定的误识别率和删除困难

造成误识别率的原因是不同元素放进布隆过滤器时可能导致分配的二进制位重合（感觉和hash冲突优点类似）。因此布隆过滤器判断元素是否存有两种情况：如果判断不存在，那一定是不存在的；而判断存在，它可能是不存在的，这个还需要去具体的数据库或者缓存里面去进一步验证。

**LRU Cache(Last Recently Used cache)**是一个使用比较多的缓存替换算法，最近最长使用缓存，它比较符合人脑的思维，如果一个物品，你如果很长时间没有使用的话，算法就会将其舍弃，且一个物品你前段时间没用最近开始使用了，算法会将这个物品放到最前面。它的实现一般基于HashMap+LinkedList(双向链表)实现，java里面有现成的实现->linkedHashMap。

#### 排序算法

主要分为两类，比较类排序和非比较类排序，比较类在java里面可以理解为会传递Comparator，而非比较类的话一般是对整形数据进行排序，时间复杂度一般是线性的为O(n)。

##### 比较类排序

- 交换排序
  - 冒泡排序
  - 快速排序
- 插入排序
  - 简单插入排序
  - 希尔排序
- 选择排序
  - 简单选择排序
  - 堆排序
- 归并排序
  - 二路归并排序
  - 多路归并排序

##### 非比较类排序

- 计数排序
- 桶排序
- 基数排序

排序里面比较不太好理解的主要是快速排序和归并排序，它们都是基于递归分治的思想进行的排序，只是具体实现细节有点区别而已。

快速排序模板

```java
public static void quickSort(int[] array, int begin, int end) {    
            if (end <= begin) return;    
            int pivot = partition(array, begin, end);    
            quickSort(array, begin, pivot - 1);    
            quickSort(array, pivot + 1, end);
        }
            
        static int partition(int[] a, int begin, int end) {    
            // pivot: 标杆位置，counter: 小于pivot的元素的个数    
            int pivot = end, counter = begin;    
            for (int i = begin; i < end; i++) {        
                if (a[i] < a[pivot]) {            
                    int temp = a[counter]; 
                a[counter] = a[i]; a[i] = temp;            
                    counter++;        
                }    
            }    
            int temp = a[pivot]; 
            a[pivot] = a[counter]; 
            a[counter] = temp;    
            return counter;
        }
```

归并排序模板：

```java
public static void mergeSort(int[] array, int left, int right) {    
            if (right <= left) return;    
            int mid = (left + right) >> 1; // (left + right) / 2    
            mergeSort(array, left, mid);   
            mergeSort(array, mid + 1, right);    
            merge(array, left, mid, right);
        }
        
        public static void merge(int[] arr, int left, int mid, int right) {        
            int[] temp = new int[right - left + 1]; // 中间数组        
            int i = left, j = mid + 1, k = 0;        
            while (i <= mid && j <= right) {            
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];        
            }        
            
            while (i <= mid)   temp[k++] = arr[i++];        
            while (j <= right) temp[k++] = arr[j++]; 
                  
            for (int p = 0; p < temp.length; p++) {            
                arr[left + p] = temp[p];        
            }        
            // 也可以用 System.arraycopy(a, start1, b, start2, length)    }
```

堆排序模板：

```java
static void heapify(int[] array, int length, int i) {    
            int left = 2 * i + 1, right = 2 * i + 2；    
            int largest = i;    
            if (left < length && array[left] > array[largest]) {        
                largest = left;    
            }    
            
            if (right < length && array[right] > array[largest]) {        
                largest = right;    
            }    
            
            if (largest != i) {        
                int temp = array[i]; 
            array[i] = array[largest]; 
            array[largest] = temp;        
                heapify(array, length, largest);    
            }
        }
        
        
        public static void heapSort(int[] array) {    
            if (array.length == 0) return;    
            int length = array.length;    
            for (int i = length / 2-1; i >= 0; i-)  heapify(array, length, i);    
            for (int i = length - 1; i >= 0; i--) {        
                int temp = array[0]; 
                array[0] = array[i]; 
                array[i] = temp;        
                heapify(array, i, 0);    
            }
        }
```

#### 高级动态规划

高级动态规划和普通动态规划的区别主要是维度上去了，普通的动态规划维度一般是1-2维，推理相对简单，且其实不太需要你去进行过多的逻辑抽象，但是到了高级动态规划就不一样了，需要你一定的逻辑抽象能力，且状态转移方程定义会比较复杂，有时候状态定义过多还需要进行**状态压缩**。这些都对基本功有一定的要求。

这块其实也没有什么好的方法，运用五毒神掌，多练多想，形成思维记忆即可。
###三种基础排序模板
#### 排序算法

##### 选择排序

```java
        if(n<=0) return;
        for(int i=0;i<n;i++){
             int min=i;
             for(int j=i;j<n;j++){
                  if(a[j] < a[min]) min=j;
             }
             if(min != i){
                  int temp=a[i];
                  a[i]=a[min];
                  a[min]=temp;
             }
      	}
```

##### 插入排序

```java
  // 插入排序，a表示数组，n表示数组大小
  if (n <= 1) return;

  for (int i = 1; i < n; ++i) {
    int value = a[i];
    int j = i - 1;
    // 查找插入的位置
    for (; j >= 0; --j) {
      if (a[j] > value) {
        a[j+1] = a[j];  // 数据移动
      } else {
        break;
      }
    }
    a[j+1] = value; // 插入数据
  }

```

##### 冒泡排序

```java
 // 插入排序，a表示数组，n表示数组大小
 if (n <= 1) return;
 
 for (int i = 0; i < n; ++i) {
    // 提前退出冒泡循环的标志位
    boolean flag = false;
    for (int j = 0; j < n - i - 1; ++j) {
      if (a[j] > a[j+1]) { // 交换
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
        flag = true;  // 表示有数据交换      
      }
    }
    if (!flag) break;  // 没有数据交换，提前退出
  }

```

