package dahua;

/**
 * 大花笔试：测试静态代码块，构造函数，继承的子类的静态代码块和构造函数的运行速度
 * （a,c,b,d,b,d）
 */
class test02 {
    static {
        System.out.println("a");
    }

    public test02() {
        System.out.println("b");
    }
}
class B extends test02{
    static {
        System.out.println("c");
    }

    public B() {
        System.out.println("d");
    }
}
public class test01{
    public static void main(String[] args) {
        test02 b = new B();
        b = new B();


    }
}
