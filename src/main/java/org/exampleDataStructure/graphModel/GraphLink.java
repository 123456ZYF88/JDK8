package org.exampleDataStructure.graphModel;

/**
 * @Author HeaList
 * @Date 于 2017-01-21 00:12:45 发布
 * @Version 1.0
 * <a href="https://blog.csdn.net/Healist/article/details/54637961">...</a>
 *相邻表法
 */
/*图形A有n个顶点，则用n个表（链表）来表示，
每个顶点后面接着的表节点元素表示该顶点到该元素存在边，
每个表的最后一个元素为null。*/
public class GraphLink {
    public Node first;
    public Node last;
    public boolean isEmpty(){
        return first == null;
    }
    public void print(){
        Node current = first;
        while(current != null){
            System.out.print("["+current.x+"]");
            current = current.next;
        }
        System.out.println();
    }
    public void insert(int x){
        Node newNode = new Node(x);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }

    public static void main(String[] args) {
        int Data[][] = { {1,2}, {2,1}, {1,5}, {5,1}, {2,3}, {3,2}, {2,4},
                {4,2}, {3,4}, {4,3}, {3,5}, {5,3}, {4,5}, {5,4} };
        int DataNum = 0;
        int i=0,j=0;
        System.out.println("图型的邻接表内容：" );
        GraphLink[] graph = new GraphLink[6];
        for (int k = 0; k < 6; k++) {
            graph[k] = new GraphLink();
            System.out.println("顶点"+k+"=>");
            for (int l = 0; l < 14; l++) {
                if(Data[l][0] == k){
                    DataNum = Data[l][1];
                    graph[k].insert(DataNum);

                }
            }
            graph[k].print();
        }

    }
}

class Node{
    int x;
    Node next;
    public Node(int X){
        this.x = X;
        this.next= null;
    }
}