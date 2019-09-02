package DemoTemplate;

public class templateMethodBank {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        BankTemplateMethod btm2 = new ManageMoney();
        btm2.process();

    }
}

abstract class BankTemplateMethod{
    //具体方法
    public void takeNumber(){
        System.out.println("取号");
    }
    public abstract void transact();//办理具体业务，钩子方法

    public void evaluate(){
        System.out.println("评价");
    }

    //模板方法，把基本业务组合到一起，子类一般不能重写
    public final void process(){
        this.takeNumber();
        this.transact();//像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码
        this.evaluate();
    }
}

class DrawMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要取款");
    }
}

class ManageMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要理财");
    }
}
