package singleton;

/**
 * 单例设计模式
 * 对某个类只能存在一个对象实例
 * 如何实现：
 *
 */
public class SingletonTest {
    public static void main(String[] args) {
//        Bank bank1 =new Bank();
//        Bank bank2 = new Bank();
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1==bank2);

    }
}

//饿汉式
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }

    //2.内部创建类的对象
    //4.要求此对象也必须为静态的
    private static Bank instance = new Bank();

    //3.提供公共的静态方法调用返回类的对象

    public static Bank getInstance() {
        return instance;
    }
}
