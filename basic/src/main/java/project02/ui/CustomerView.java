package project02.ui;

import project02.bean.Customer;
import project02.service.CustomerList;
import project02.util.CMUtility;

/**
 * 主模块，负责菜单的显示和处理用户操作
 * 封装以下信息:
 *  >CustomerList customerList = new CustomerList(10)
 *  创建最大包含10个客户对象的CustomerList对象，供使用
 */
public class CustomerView {
    private CustomerList customerLists = new CustomerList(10);

    public CustomerView() {
        //为了测试功能4
//        Customer customer = new Customer("aa",'男',23,"12312","12@gmail.com");
//        customerLists.addCustomer(customer);
    }

    /**
     * 显示菜单的主界面
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("------客户信息管理软件------\n");
            System.out.println("         1.添加客户");
            System.out.println("         2.修改客户");
            System.out.println("         3.删除客户");
            System.out.println("         4.客户列表");
            System.out.println("         5.退    出\n");
            System.out.print("        请选择（1-5）：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit=='Y'){   //基本数据类型不能用.equals
                        isFlag = false;
                    }


            }



        }
    }
    private void addNewCustomer(){
        System.out.println("--------添加客户-------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);

        System.out.print("性别：");
        char gender = CMUtility.readChar();

        System.out.print("年龄：");
        int age = CMUtility.readInt();

        System.out.print("电话：");
        String phone = CMUtility.readString(11);

        System.out.print("邮箱：");
        String mail = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name,gender,age,phone,mail);
        boolean isSuccess = customerLists.addCustomer(customer);
        if(isSuccess){
            System.out.println("------添加完成--------");
        }else{
            System.out.println("-----客户目录已满，添加失败--------");
        }

    }
    private void modifyCustomer(){
        System.out.println("--------修改客户--------");
        Customer cust;
        int number;
        for(;;){
            System.out.print("请选择待修改客户编号（-1退出）：");
             number = CMUtility.readInt();

            if(number==-1){
                return;
            }
            cust = customerLists.getCustomer(number - 1);
            if(cust==null){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }
        //通过break走到这
        System.out.print("姓名（"+cust.getName()+"):");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别（"+cust.getGender()+"):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（"+cust.getAge()+"):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（"+cust.getPhone()+"):");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱（"+cust.getEmail()+"):");
        String mail = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name,gender,age,phone,mail);

        boolean isReplace = customerLists.replaceCustomer(number - 1, newCust);
        if(isReplace){
            System.out.println("-------修改成功--------");
        }else{
            System.out.println("-------修改失败--------");
        }


    }
    private void deleteCustomer(){
        System.out.println("---------删除客户--------");
        int number;
        for (;;){
            System.out.println("请选择待删除客户的编号（-1退出）：");
            number = CMUtility.readInt();


            if(number==-1){
                return;
            }

            Customer customer = customerLists.getCustomer(number - 1);
            if(customer==null){
                System.out.println("无法找到指定用户");
            }else{
                break;
            }
        }
        //找到了指定账户
        System.out.print("确认是否删除（Y/N）:");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean deleteSuccess = customerLists.deleteCustomer(number - 1);
            if(deleteSuccess){
                System.out.println("----------删除成功-------");
            }else{
                System.out.println("--------删除失败---------");
            }

        }


    }
    private void listAllCustomers(){
        System.out.println("------客户列表------\n");
        int total = customerLists.getTotal();
        if(total == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
            Customer[] custs = customerLists.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i+1)+"\t\t"+cust.getName()+
                        "\t\t"+cust.getGender()+"\t\t"+cust.getAge()+
                        "\t\t"+cust.getPhone()+"\t"+cust.getEmail());
            }
        }


        System.out.println("------客户列表完成------\n");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }
}
