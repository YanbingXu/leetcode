package singleton;

/**
 * 懒汉式的线程安全写法
 */
public class SingletonTest3 {
    public static void main(String[] args) {

    }
}

class Bank1 {
    private Bank1() {

    }

    private static Bank1 instance = null;

    private static Bank1 getInstance() {

        if (instance == null) {
            synchronized (Bank1.class) {
                if (instance == null) {
                    instance = new Bank1();
                }

            }
        }
        return instance;
    }
}
