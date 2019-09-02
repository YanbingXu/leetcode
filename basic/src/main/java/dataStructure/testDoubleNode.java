package dataStructure;

import demoNode.LoopDoubleNode;

public class testDoubleNode {
    public static void main(String[] args) {
        LoopDoubleNode n1 = new LoopDoubleNode(1);
        LoopDoubleNode n2 = new LoopDoubleNode(2);
        LoopDoubleNode n3 = new LoopDoubleNode(3);
//
//        System.out.println(n1.getData());
//        System.out.println(n1.getNext().getData());
//        System.out.println(n1.getPre().getData());

        n1.after(n2);
        n2.after(n3);
        System.out.println(n2.getData());
        System.out.println(n2.getNext().getData());
        System.out.println(n2.getPre().getData());
        System.out.println(n1.getPre().getData());
        System.out.println(n1.getNext().getData());
        System.out.println(n3.getNext().getData());
        System.out.println(n3.getPre().getData());

    }
}
