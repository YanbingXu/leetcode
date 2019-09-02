package demoNode;

/**
 * 这是单链表的基本操作，比如追加节点
 */
public class LoopNode {
    //节点内容
    int data;
    //下一个结点 类型应该仍然是节点
    LoopNode next=this;

    //构造函数
    public LoopNode(int value){
       this.data = value;
    }



    //删除节点：无法找上一个节点。就利用上一节点的next方法来删除这个结点。通过把下下个赋给下一个删除
    public void removeNext(){
        //已定义下一个节点为next
        LoopNode newNode = next.next;
        this.next = newNode;
    }

    //插入一个节点的方法：新节点=this.next 老节点=新节点.next。定位始终是在指定位置的上一个地方
    public void after(LoopNode node){
        //找出老节点并保存(取出下一个节点作为下下个节点)
        LoopNode nextNext = next;

        this.next = node;
        node.next = nextNext;

    }



    //取下一个节点
    public LoopNode next(){
        return this.next;
    }

    //查看节点的数据
    public int getdata(){
        return this.data;
    }

}
