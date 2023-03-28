 
### 1、Stream流式思想概述
注意：Stream和IO流(InputStream/OutputStream)没有任何关系，请暂时忘记对传统IO流的固有印象！

Stream流式思想类似于工厂车间的“生产流水线”，Stream流不是一种数据结构，不保存数据，而是对数据进行加工
处理。Stream可以看作是流水线上的一个工序。在流水线上，通过多个工序让一个原材料加工成一个商品。

![](../../static/png/img.png)
![](../../static/png/img_1.png)![](../../static/png/img_2.png)

Stream API能让我们快速完成许多复杂的操作，如筛选、切片、映射、查找、去除重复，统计，匹配和归约
### 2、获取Stream流的两种方式
- 所有的 Collection 集合都可以通过 stream 默认方法获取流；
- Stream 接口的静态方法 of 可以获取数组对应的流。

方式1 : 根据Collection获取流
首先， java.util.Collection 接口中加入了default方法 stream 用来获取流，所以其所有实现类均可获取流。

方式2 : Stream中的静态方法of获取流
由于数组对象不可能添加默认方法，所以 Stream 接口中提供了静态方法 of ，使用很简单：

### 3、Stream常用方法

|  方法名   | 方法作用  | 返回值类型 | 方法种类|
|  ----  | ----  | ----  |  ----  |
| count  | 统计个数 | long  | 终结 |
| forEach  | 逐一处理 | void  | 终结 |
| filter  | 过滤 | Stream  | 函数拼接 |
| limit  | 取用前几个 | Stream  | 函数拼接 |
| skip  | 跳过前几个 | Stream  | 函数拼接 |
| map  | 映射 | Stream  | 函数拼接 |
| concat  | 组合 | Stream  | 函数拼接 |



- 终结方法：返回值类型不再是 Stream 类型的方法，不再支持链式调用。本小节中，终结方法包括 count 和
forEach 方法。
- 非终结方法：返回值类型仍然是 Stream 类型的方法，支持链式调用。（除了终结方法外，其余方法均为非终结
方法。）
### 4、 Stream注意事项(重要)
**1. Stream只能操作一次**\
**2. Stream方法返回的是新的流**\
**3. Stream不调用终结方法，中间的操作不会执行**