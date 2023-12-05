package org.exampleDataStructure.graphModel;

/**
 * @Author HeaList
 * @Date 于 2017-01-21 00:12:45 发布
 * @Version 1.0
 * <a href="https://blog.csdn.net/Healist/article/details/54637961">...</a>
 *相邻矩阵法
 * ADJACENT_MATRIX_METHOD
 */
public class NeighburArray {
    /*
    有多少个顶点（n）就用多少长度的二维数组（arr[n][n]）来表示图，
    某个点arr[x][y]值为1则表示对应顶点有边存在，为0则表示对应顶点无边存在。
    */
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int i, j,tmpi,tmpj;
        int data[][] = {{1,2},{2,1},{1,3},{3,1},{2,4}};

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                arr[i][j] = 0;
        }
        for (i = 0; i < 5; i++) {
            tmpi = data[i][0];
            tmpj = data[i][1];
            arr[tmpi-1][tmpj-1] = 1;
        }
        System.out.println("邻接矩阵为(有向矩阵)：");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                System.out.print("["+ arr[i][j]+"]");
            System.out.println();
        }
    }
}
/*相邻矩阵法是一种常用的图的表示方法，它在代码中有以下好处：

1. 易于实现：相邻矩阵法使用二维数组来表示图，这是一种非常直观且易于实现的数据结构。

2. 查询快速：如果你想知道两个顶点之间是否存在边，只需要通过索引直接访问二维数组的相应位置即可，这个操作的时间复杂度是O(1)。

3. 适合稠密图：对于边数较多的图（稠密图），相邻矩阵法的空间利用率较高。

然而，相邻矩阵法也有其缺点。例如，它不适合表示边数较少的图（稀疏图），因为这会导致大量的数组空间被浪费。
此外，如果图的顶点数目在运行时是可变的，那么使用相邻矩阵法会比较麻烦，因为需要重新分配数组空间。*/