package threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的方式三：1。同步代码块 2。同步方法 3。lock锁（前两种方法合起来叫synchronized）
 *
 * 面试题：synchronized与lock的异同？
 * 同：都可以解决线程安全问题
 * 不同：1）synchronized在执行完相应的同步代码后自动释放同步监视器，lock需要手动的启动同步以及结束同步
 * 2）lock只有代码块锁，synchronized有代码块锁和方法锁
 * 3）使用lock，jvm将花费较少的时间来调度线程，性能更好，并且具有更好的扩展性（提供更多的子类）。
 *
 *面试题：如何解决线程安全，有三种方式？
 */

//首先创建多线程，方法有两个，一个是继承（extends），一个是实现（implements）
class Window implements Runnable{
    private int ticket = 100;

    //怎么实现lock锁解决线程安全问题呢
    //1.实例化reentranlock
    private ReentrantLock lock = new ReentrantLock();



    @Override
    public void run() {
        while(true){
            try{
                //2.调用lock（）保证这一块是单线程执行
                lock.lock();



                if(ticket>0){

                    //为了让重票错票概率大一点，写上sleep方法
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":售票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.解锁
                lock.unlock();
            }


        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }


}
