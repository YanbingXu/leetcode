package Demostack;

public class MyStack {
    private int[] elements;

    public MyStack(){
        elements=new int[0];
    }
    //压入操作，在数组最后加一个元素
    public void push(int element){
        int[] newArr = new int[elements.length+1];
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        newArr[elements.length]=element;
        elements=newArr;
    }
    //弹出操作，数组最后一位元素弹出
    public int pop(){
        if(elements.length==0){
            throw new RuntimeException("the stack is empty");
        }
        int element = elements[elements.length-1];
        int[] newArr = new int[elements.length-1];
        for(int i =0;i<newArr.length;i++){
            newArr[i]=elements[i];
        }
        elements=newArr;
        return element;
    }
    //查看栈顶元素
    public int peek(){
        if(elements.length==0){
            throw new RuntimeException("the stack is empty");
        }
        return elements[elements.length-1];
    }
    //判断栈是否为空
    public boolean isempty(){
        return elements.length==0;
    }
}
