package vivo0604;

import java.util.Random;
import java.util.Scanner;

/**
 * 题目描述：给定一个链表，翻转该链表从m到n的位置。要求：直接翻转而非申请新的空间；
 如：给定1–>2–>3–>4–>5，m=2，n=4；m，n满足1<=m<=n<=链表长度；
 返回1–>4–>3–>2–>5


 */
public class test02 {
    public static void main(String[] args) {
        int m,n;//输入要改变部分的链表起始位置和结束位置
        //生成100以内的随机数
        Random random=new Random(100);
        //初始化一个单链表，头结点为空
        Node head = new Node();
        Node pre = head;
        for(int i=0;i<20;i++){
            Node node = new Node(random.nextInt(100));
            pre.next=node;//尾插法构建链表
            pre=node;
        }
        System.out.println("原链表：");
        Node repeat = head.next;
        while(repeat!=null){
            System.out.print(repeat.value+" ");
            repeat=repeat.next;
        }
        System.out.println();

        System.out.println("翻转链表的范围m和n：");
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        System.out.println("m= "+m+" n= "+n);

        //翻转链表
        reverse(head,m,n);
//        System.out.println("翻转之后的链表：");
//        while (head.next!=null){
//            System.out.print(head.next.value+" ");
//            head=head.next;
//        }
    }

    /**
     *
     * @param head 连标点额头结点
     * @param m 翻转的开始位置
     * @param n 翻转的结束位置
     */
    private static void reverse(Node head, int m, int n) {
//        if(m>=n){
//            return;
//        }
//
//        Node cur = head.next;
//        int i;
//        for(i=0;i<m-1;i++){
//            head=cur;
//            //System.out.print(head.value+" ");
//            cur=cur.next;
//        }
//        Node pre = cur;
//        cur=cur.next;
//        n--;
//        Node next;
//        for(;i<n;i++){
//            next=cur.next;
//            cur.next=head.next;//采用头插法
//            head.next = cur;
//            pre.next = next;
//            cur=next;
//        }

    }
}
