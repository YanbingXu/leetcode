package dataStructure;

import Demostack.MyStack;

public class TestMyStack {


    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        //System.out.println(ms.peek());
        System.out.println(ms.isempty());
    }
}
