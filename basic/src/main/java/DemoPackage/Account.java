package DemoPackage;

/**
 * 写一个名为Account的类模拟账户。
 * 该类的属性：账号id，余额balance，年利率annualinterestRate；
 * 方法:访问器方法（getter和setter），取款方法withdraw，存款方法deposite
 */

public class Account {
    private int id;//账号
    private double balance;//余额
    private double annualInterestRate; // 年利率

//    public Account() {
//    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * 需要判断用户余额是否能够满足提款数额的要求，如果不能，给出提示
     * @param amount
     */
    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("您的余额不足,取款失败");
        }else{
            balance = balance-amount;
            System.out.println("您已成功取出："+amount+",您的余额还有："+balance);
        }

    }


    /**
     *
     * @param amount
     */
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("成功存入："+amount);
        }

    }
}
