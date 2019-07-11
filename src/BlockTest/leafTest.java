package BlockTest;
//总结：由父及子，静态先行

class Root{
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }

    public Root() {
        System.out.println("Root的无参数构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化块");
    }

    {
        System.out.println("Mid的普通初始化块");
    }

    public Mid() {
        System.out.println("Mid的无参数构造器");
    }

    public Mid(String msg){
        //通过this调用同一个类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值："
        + msg);
    }

}

class Leaf extends Mid{
    static {
        System.out.println("leaf的静态初始化块");
    }
    {
        System.out.println("leaf的普通初始化块");
    }

    public Leaf() {
        //通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("leaf的构造器");
    }
}
public class leafTest {
    public static void main(String[] args) {
        new Leaf();
    }
}
