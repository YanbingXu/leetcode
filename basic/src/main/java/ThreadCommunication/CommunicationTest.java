package ThreadCommunication;

/**
 * 线程通信的例子：用两个线程交替打印1-100
 *
 * 涉及到的三个方法
 * 前提：只能在同步代码块或者同步方法中使用，lock也不行
 * 前提2：这三个方法的调用者必须是同步代码块或者同步方法中的同步监视器。
 *       否则会出IllegalMonitorStateException错
 * 前提3：这三个方法定义在java.lang.Object类中
 * 1）wait（）：一旦执行，当前进程进入阻塞状态，并释放同步监视器
 * 2）notify（）：一旦执行，就会唤醒被wait的一个线程，如果有多个线程被wait，唤醒优先级高的那个
 * 3）notifyAll（）：一旦执行，唤醒所有被wait的线程。
 *
 *
 *
 * 面试题：sleep和wait的异同
 * 相同：都可以让当前线程进入阻塞状态
 * 不同点：1）声明位置不一样，thread类中声明sleep（），object类中声明wait（）
 *        2）调用范围不一样，sleep的调用没有任何要求，wait（）一定要在同步代码块或者同步方法中调用
 *        3）关于是否释放同步监视器的问题，如果两个方法都使用在同步代码块或者同步方法中，sleep不会释放锁，
 *        而wait（）会释放同步监视器。
 */

class Number implements Runnable{

    private int number=1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {

                //唤醒之前被阻塞的线程
                notify();

                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    //阻塞当前线程，使得下一线程得以开始，达到交替目的
                    try {
                        wait();//注意：一旦执行wait，锁就会被释放，和sleep不同。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }

    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
