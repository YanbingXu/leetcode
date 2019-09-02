package DemoPackage;

/**
 * 写一个测试程序
 * （1）创建一个customer，名字叫Jane Smith,他有一个账号为1000。余额为2000元，年利率为1.23
 * （2）对Jane Smith进行操作
 * 存入100，取出960，再取出2000
 * 打印出Jane Smith的基本信息
 *
 * 成功存入:100.0
 * 成功取出：960.0
 * 余额不足，取款失败
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer c = new Customer("Jane","Smith");
        Account a = new Account(1000,2000,0.0123);

        c.setAccount(a);
        c.getAccount().deposit(100);
        c.getAccount().withdraw(960);
        c.getAccount().withdraw(2000);

        //打印出账户信息
        System.out.println("Customer ["+c.getFirstName()+","+c.getLastName()+"] has a account: id is "+c.getAccount().getId()+", annualInterestRate is "
        +c.getAccount().getAnnualInterestRate()+" ,balance is "+c.getAccount().getBalance());
    }
}
