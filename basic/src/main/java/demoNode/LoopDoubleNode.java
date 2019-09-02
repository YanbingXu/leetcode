package demoNode;

/**
 * 这直接就是一个循环的 双向链表
 */
public class LoopDoubleNode {
    LoopDoubleNode pre = this;
    LoopDoubleNode next = this;
    //定义一个value
    int data;

    //定义构造函数
    public LoopDoubleNode(int value){
        this.data=value;
    }

    //插入方法
    public void after(LoopDoubleNode node){
        //先保存原来的next值
        LoopDoubleNode nextNext = next;
        //node 设置为next
        this.next = node;
        //node 前驱是当前节点
        node.pre = this;
        //node 下一个节点为之前的nextNext
        node.next = nextNext;
        //nextNext的上一个节点
        nextNext.pre = node;

    }

    //获取上一个节点

    public LoopDoubleNode getPre() {
        return pre;
    }


    //获取下一个节点


    public LoopDoubleNode getNext() {
        return next;
    }

    //获取数据
    public int getData(){
        return this.data;
    }

}
