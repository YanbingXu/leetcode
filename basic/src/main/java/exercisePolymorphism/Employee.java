package exercisePolymorphism;

/**
 * 编写工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个employee对象的生日，
 * 则将该雇员的工资增加100元
 *
 * 1.定义一个employee类，该类包含：
 * private成员变量name，number，birthday，其中birthday为MyDate类的对象；
 * abstract方法earnings（）；
 * toString方法输出对象的name，number，birthday
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public abstract double earings();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}
