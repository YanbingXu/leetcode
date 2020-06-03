package ThreadCommunication;

/**
 * 线程通信的应用：生产者消费者问题
 * 生产者（producer）将产品交给店员（clerk），而消费者（consumer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品（20），如果生产者试图生产更多的产品，店员就会叫生产者
 * 停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者
 * 等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1。是否是多线程？是，生产者线程，消费者线程
 * 2。是否存在线程安全问题？（是否有共享数据） 是，共享数据是产品（店员）
 * 3。如何解决线程安全问题？ 同步机制（3种方法）
 * 4。是否涉及线程的通信？ 是，wait和notify
 */

class Clerk{
    private int productorNum = 0;

    public synchronized void produceProductor() {
        if(productorNum<20){
            productorNum++;
            System.out.println(Thread.currentThread().getName()+"生产第"+productorNum+"个产品");


            notify();


        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public synchronized void consumeProductor() {
        if(productorNum>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+productorNum+"个产品");
            productorNum--;

            notify();

        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer extends Thread{//生产者
    private Clerk clerk ;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始生产。。。。。。");
        while (true){
            clerk.produceProductor();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}

class Consumer extends Thread{//消费者线程
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费。。。。。。");
        while(true){
            clerk.consumeProductor();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();


    }
}
