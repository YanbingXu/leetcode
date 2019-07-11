package BlockTest;
class father{
    static {
        System.out.println("1111");
    }
    {
        System.out.println("222");
    }

    public father() {
        System.out.println("3333");
    }
}
public class Son extends father {
    static {
        System.out.println("4444");
    }
    {
        System.out.println("5555");
    }

    public Son() {
        System.out.println("666");
    }


    public static void main(String[] args) {//由父及子，静态先行
        System.out.println("7777");
        System.out.println("*****");
        new Son();
        System.out.println("******");
    }
}
