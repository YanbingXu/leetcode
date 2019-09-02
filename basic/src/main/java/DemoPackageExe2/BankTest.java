package DemoPackageExe2;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Jane","Smith");

        bank.getCustomers(0).setAccount(new Account(2000)); //匿名对象
        bank.getCustomers(0).getAccount().withdraw(500);

        double balance = bank.getCustomers(0).getAccount().getBalance();
        System.out.println("客户："+bank.getCustomers(0).getFirstname()+"的账户余额为："+balance);

    }
}
