package org.examle06.fullPermutationAlgorithm;


import org.junit.jupiter.api.Test;

/**
 * @Author ZhangYiFan
 * @Date 2022/9/22 14:04
 * @description:全排列
 * @Version 1.0
 */
public class FullPermutationAlgorithm01 {

    /*
     * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。
     * 当m=n时所有的排列情况叫全排列。公式：全排列数f(n)=n!(定义0!=1)
     * */

    /**
     * 交换位置
     * @param a
     * @param i
     * @param j
     */
    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 输出
     * @param A
     */
    public void printArray(int A[]) {
        for (int i = 0; i < A.length; i++) {

            System.out.print(A[i]);
        }
        System.out.println();
    }

    /**
     * 吧每一个都拿到前面，
     * @param A
     * @param p
     * @param q
     */
    public void perm(int A[], int p, int q) { //12345,0,4/ 12345,1,4/  14235,2,4
        for (int i = p; i <= q; i++) {//0/ 0 /0 /0 /0 ,/1
            if (p == q) {//0,4/ 1,4/ 2,4/ 3,4/ 4,4/
                printArray(A); //12345
            } else {
                swap(A, p, i);//12345,0,0/12345,1,4/ 12345,2,4/ 调整位置 12345,0,1 / 21345, 2,1, 3,1 ,4,1
                perm(A, p + 1, q);//12345,1,4/ 15342,2,4/ 12543,2,4/ ''''''  21345,2,4 / 23145 /2
                swap(A, p, i);//12345,0,0/ 12345,1,4 还原
            }
        }
    }

    @Test
    public  void mainTest() {
        int a[] = {1, 2, 3,4,5};
        perm(a, 0, 4);
    }

}
