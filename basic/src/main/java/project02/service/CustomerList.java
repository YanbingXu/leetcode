package project02.service;


import project02.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 */
public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total = 0;//记录已保存客户对象的数量

    /**
     * 构造器用来初始化customer数组
     * @param totalCustomer 指定customer数组的最大空间
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * 将参数 custormer添加组中最后一个客户对象记录之后
     * @param customer 指定要添加的客户对象
     * @return 添加成功返回true，false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if(total<customers.length){
            customers[total]=customer;
            total+=1;
            return true;
        }else{
            return false;
        }


    }

    /**
     * 用参数customer替换数组中由index指定的对象
     * @param index  指定所替换对象在数组中的位置，从0开始
     * @param cust customer指定替换的新客户对象
     * @return 替换成功返回true，false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index,Customer cust){
        if(index<0||index>=total){
            return false;
        }else{
            customers[index]=cust;
            return true;
        }

    }

    /**
     * 删除指定索引位置上的客户
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index){
        if(index<0||index>=total){
            return false;
        }else{
            for(int i=index;i<total-1;i++){
                customers[i]=customers[i+1];
            }
            //最后有数据的元素需要置空
            customers[total-1]=null;
            total--;
            return true;


        }

    }

    /**
     * 获取所有的客户信息
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < custs.length; i++) {
            custs[i]=customers[i];  //复制的只是地址值
        }
        return custs;

    }

    /**
     * 获取指定索引位置上的客户
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        if(index<0||index>=total) {
            return null;
        }
        return customers[index];
    }

    /**
     * 获取存储的客户数量
     * @return
     */
    public int getTotal(){
        return total;

    }
}
