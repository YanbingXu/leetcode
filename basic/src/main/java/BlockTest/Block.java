package BlockTest;

/**
 * 类的成员之四：代码块（或初始化块）
 * 1。代码块的作用：用来初始化类，对象
 * 2。代码块如果有修饰的话，只能使用static
 * 3。分类：静态代码块vs非静态代码块
 *
 * 4。静态代码块（可以定义多个，按声明的先后顺序执行，静态代码块的执行优先于非静态代码块）
 *      >内部可以有输出语句
 *      >随着类的加载而执行，只执行一次
 *      >初始化类的信息，对类中静态的属性进行赋值
 *      >静态代码块内只能调用静态的属性，静态的方法，不能调用非静态的结构
 *
 * 5。非静态代码块
 *      >内部可以有输出语句
 *      >随着对象的创建而执行
 *      >每创建一个对象，执行一次非静态代码块
 *      >作用：可以在创建对象时，对对象的属性进行初始化
 *      >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 *      >非静态代码块内部可以调用静态的属性，静态的方法，或非静态的属性，非静态的方法
 *
 * 但是一般不定义多个代码块；
 *
 * 对属性可以赋值的位置：
 * 1。默认初始化
 * 2。显示初始化
 * 3。构造器初始化
 * 4。有了对象之后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * 5。在代码块赋值
 *
 *
 */
public class Block {
    public static void main(String[] args) {
        String desc = Person.desc;
        System.out.println(desc);

        Person p1 = new Person();
//        Person p2 = new Person();
        System.out.println(p1.age);

        Person.info();
    }
}


class Person{
    //属性
    String name;
    int age;
    static String desc = "我是一个人";

    //构造器

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //static的代码块
    static {
        System.out.println("hello,static block");
    }

    //非static的代码块
    {
        System.out.println("hello,block");
        age=12;
    }

    //方法
    public void eat(){
        System.out.println("吃饭");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void info(){
        System.out.println("我是一个快乐的人！");
    }
}