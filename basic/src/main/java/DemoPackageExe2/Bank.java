package DemoPackageExe2;

public class Bank {
    private Customer[] customers;//存放多个客户的数组    数组需要new一个对象
    private int numberOfCustomers;//记录客户的个数

    public Bank() {
        customers = new Customer[10];
    }

    /**
     * 添加客户
     * @param f
     * @param l
     */
    public void addCustomer(String f,String l){
        Customer cust =  new Customer(f,l);
        customers[numberOfCustomers] = cust;
        numberOfCustomers++;

    }

    /**
     * 获取客户的个数
     * @return
     */
    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    /**
     * 获取指定位置上的客户
     * @return
     */
    public Customer getCustomers(int index) {
        if(index>=0&&index<numberOfCustomers){
            return customers[index];
        }
        return null;

    }
}
