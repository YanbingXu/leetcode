package threadTest;

/**
 *演示线程的死锁问题
 *
 * 1。死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，
 * 就形成了线程的死锁
 *
 * 2。说明：
 *    1）死锁出现后没有异常，没有提示，只是所有线程阻塞，无法继续
 *    2）同步时要避免出现死锁
 * 3。解决方法：
 *   1）专门的算法、原则
 *   2）尽量减少同步资源的定义
 *   3）尽量避免嵌套同步
 *
 */
public class threadTest {
    public static void main(String[] args) {
        //造两个对象
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        //线程的创建有两种方式，一种叫继承，一种叫实现runnable接口
        //用匿名的方式来创造线程
        new Thread(){
            @Override
            public void run() {
                //同步监视器s1当锁
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    //死锁出现可能大大增加：增加sleep方法使线程阻塞
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //锁是嵌套关系，用s2充当
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);


                    }

                }
            }
        }.start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //锁是嵌套关系，用s1充当
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);


                    }
                }
            }

        }).start();





    }

}
