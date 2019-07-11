package demoNode;

/**
 * 这是单链表的基本操作，比如追加节点
 */
public class Node {
    //节点内容
    int data;
    //下一个结点 类型应该仍然是节点
    Node next;

    //构造函数
    public Node(int value){
       this.data = value;
    }

    //追加函数
    public Node append(Node node){
        //这个就可以完全追加函数了但是不好的地方在哪里呢？this.next = node 我们希望找到它没有下一个节点了之后再追加。
        //question：append追加的是下一个node的地址还是数据？

        //首先保存一下当前的节点
        Node currentNode = this;
        //无限循环找它的下一个节点

        while (true){
            Node nextNode = currentNode.next;
            if(nextNode==null){
                break;
            }
            //如果nextnode不能空，就把它赋给当前节点
            currentNode = nextNode;
        }
        currentNode.next = node;
        //改进方法:把自己返回出去
        return this;

    }

    //删除节点：无法找上一个节点。就利用上一节点的next方法来删除这个结点。通过把下下个赋给下一个删除
    public void removeNext(){
        //已定义下一个节点为next
        Node newNode = next.next;
        this.next = newNode;
    }

    //插入一个节点的方法：新节点=this.next 老节点=新节点.next。定位始终是在指定位置的上一个地方
    public void after(Node node){
        //找出老节点并保存(取出下一个节点作为下下个节点)
        Node nextNext = next;

        this.next = node;
        node.next = nextNext;

    }

    //写一个显示节点的方法
    public void show(){
        Node currentNode = this;
        while(true){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.next;
            if(currentNode==null){
                break;
            }
        }
        System.out.println();
    }

    //取下一个节点
    public Node next(){
        return this.next;
    }

    //查看节点的数据
    public int getdata(){
        return this.data;
    }
    //检查节点是否为最后一个
    public boolean isLast(){
        return next==null;
    }
}
