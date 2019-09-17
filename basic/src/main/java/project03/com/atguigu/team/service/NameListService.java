package project03.com.atguigu.team.service;

import project03.com.atguigu.team.domain.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供
 * 相关操作Employee[]的方法
 */
public class NameListService {
    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService() {
//        根据项目提供的Data类构建相应大小的employees数组
//        再根据Data类中的数据构建不同的对象，包括Employee，Programmer，Designer和architect
//        将对象存于数组中
        employees = new Employee[Data.EMPLOYEES.length];

        for(int i=0;i<employees.length;i++){
            //获取员工的类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            //获取employee的4个基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;

            }
        }

    }

    /**
     * 获取指定index位置上的员工设备
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        String modelOrName = Data.EQUIPMENTS[index][1];
        switch (key){
            case Data.PC:
                String display = Data.EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new Notebook(modelOrName,price);
            case Data.PRINTER:
                String type = Data.EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);

        }
        return null;
    }

    /**
     * 获取当前的所有员工（相当于把私有的域拿出来）
     * @return
     */
    public Employee[] getAllEmployees(){

        return employees;
    }

    /**
     * 获取指定id的员工对象，没有id就抛一个自定义的异常
     * @param id
     * @return
     */
    public Employee getemployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];

            }
        }
        //自定义的用throws，最后再catch
        throw new TeamException("找不到指定的员工");
    }

}
