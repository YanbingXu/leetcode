package dataStructure;

public class testRecusive {
    //递归的定义
    public static void main(String[] args) {
       print(3);
    }
    //定义一个print函数
    public static void print(int i){
        if(i>0){
            System.out.println(i);
            print(i-1);//直接递归会无限循环知道栈溢出
        }

    }
}
