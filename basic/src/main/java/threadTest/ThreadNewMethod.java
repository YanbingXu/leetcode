package threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * jdk5.0新增两个创建线程的方式
 * 1）实现callable接口
 *     与runnable相比，callable的功能更加强，相比run（）方法，call（）方法可以有返回值；
 *     方法可以抛异常；
 *     支持范型的返回值；
 *     需要借助FutureTask类，比如获取返回值结果
 *          Future接口：
 *              可以对具体Runnable Callable任务的执行结果进行取消，查询是否完成，获取结果等
 *              FutureTask是Future接口的唯一实现类
 *              FutureTask同时实现了Runnable，Future接口，他既可以作为Runnable被线程执行，又可以作为
 *              Future得到Callable的返回值
 *
 *
 * 如何理解实现callable接口的方式创建多线程比实现runnable接口更强大？回答上面callable的特点
 *
 *
 */


//1。创建一个实现callable接口的实现类
class ThreadNUM implements Callable{
    //2。实现call（），将此线程需要执行的操作声明在call（）中，call（）可以有返回值
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }
}
public class ThreadNewMethod {
    public static void main(String[] args) {
        //3。创建callable接口实现类的对象
        ThreadNUM threadNUM = new ThreadNUM();
        //4。将此callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(threadNUM);
        //5。将FutureTask对象作为参数传递到thread类的构造器中，创建Thread的对象并start方法调用
        new Thread(futureTask).start();

        try {

            //6。获取callable中的call方法的返回值
            //get（）返回值即为FutureTask构造器参数callable实现类重写的call（）的返回值
            Object sum = futureTask.get();
            System.out.println("总和为："+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
