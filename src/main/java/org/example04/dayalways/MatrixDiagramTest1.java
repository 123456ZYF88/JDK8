package org.example04.dayalways;

/**
 * 参考作者 ： "?abc!"
  <a href="https://blog.csdn.net/yyuggjggg/article/details/124268531">...</a>
 */
public class MatrixDiagramTest1 {
    //给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出: 6
    //解释:上面是由数组[0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水(蓝色部分表示雨水)
//示例 2:
    //输入: height = [4,2,0,3,2,5]    : 1+3+2+1
    //输出:9
    public static void main(String[] args) {
      int[] ad = {11,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(ad);
        System.out.println(trap);
    }

    public static int trap(int[] args) {
        //初始化左右指针
        int left=0,right = args.length-1;
        //初始化结果值
        int ans = 0;
        //初始化左右的最大值
        int left_max = 0,right_max = 0;
        //退出条件 左指针大于等于右指针
        while(left < right){
            //只要right_max[i] > left_max[i] 积水高度将由 left_max 决定
            if (args[left] < args[right] ){ //当前最大值在left
                //当当前位置的值大于之前的最大值 不进行累加
                if (args[left]>= left_max){
                    //所以需要将最大值进行替换当前值
                    left_max = args[left];
                }else {//当前位置的值小于之前的最大值，可以累加
                    //按列进行相加 ，最大值减去当前位置的高度就为所求
                    ans += (left_max - args[left]);
                }
                //向右位移
                ++ left;
            }else {//这个时候最大值在右边
                if (args[right] >= right_max){
                    right_max = args[right];
                }else {
                    ans += (right_max - args[right]);
                }
                //向左移动
                --right;
            }
        }
        return ans;
    }

}
