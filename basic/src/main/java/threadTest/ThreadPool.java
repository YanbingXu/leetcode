package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1。提高响应速度（减少了创建新线程的时间）
 * 2。降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3。便于线程管理
 *  corePoolSize：核心池的大小
 *  maximumPoolSize:最大线程数
 *  keepAliveTime:线程没有任务时最多保持多长时间后会终止
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }

        }
    }
}


class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if(i%2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }

        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1。提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);//ExecutorService是接口，这是多态形式

        //2。执行指定的线程操作，需要提供实现runnable接口或callable接口实现类的对象
        service.execute(new NumberThread());//适用与runnable
        service.execute(new NumberThread1());//主要是为了告知这一线程要完成的是什么事
//        service.submit();//适用于callable

        //3。关闭连接池
        service.shutdown();
    }
}
