package DemoPackage;

/**
 * 面向对象特性一：封装与隐藏
 * 一、问题的引入
 * 当我们创建一个类的对象之后，我们可以通过“对象.属性”的方式，对对象的属性进行赋值。这里赋值操作要受
 * 属性的数据类型和存储范围的制约。除此之外，没有其他制约条件。但是在实际问题中我们往往需要给属性赋值
 * 加入额外的限制条件。这个条件就不能再属性声明时体现，我们只能通过方法进行限制条件的添加。（比如set get）
 * 同时，我们需要避免用户再使用“对象.属性”的方式对属性进行赋值，则需要将属性声明为私有的（private）
 * -->此时 针对于属性就体现了封装性。
 *
 * 二、封装性的体现
 * 我们将类的属性私有化（private）同时提供公共（public）的放来来获取（getXXX）和设置（setXXX）此属性的值
 *
 * 拓展：
 * 封装性的体现：1、如上 2、不对外暴露的私有的方法 3、单例模式
 *
 * 三、封装性的体现需要权限修饰符来配合
 * 1、java规定的4种权限（从小到大排列）：private、缺省、protected、public
 * 2、四种权限可以用来修饰类以及类的内部结构：属性、方法、构造器、内部类
 * 3、具体的，4种权限都可以用来修饰类的内部结构 属性、方法、构造器、内部类
 *            修饰类的话，只能用public和缺省
 *
 */
public class AnimalTest {
    public static void main(String[] args) {

        Animal a = new Animal();
        a.name="大黄";
        a.age =1;
        //a.leg = 4; //有问题。-4也可编译通过
        a.setLeg(6);

        a.show();

    }
}

class Animal{
    String name;
    int age;
//    int leg; //腿的个数
    private int leg;//通过权限修饰符来禁止直接调用的方式

    //对属性的设置
    public void setLeg(int i){
        if(i>=0&&i%2==0){
            leg = i;
        }else{
            leg=0;
        }
    }

    //对属性的获取
    public int getLeg(){
        return leg;
    }

    public void eat(){
        System.out.println("动物进食");

    }

    public void show(){
        System.out.println("name="+name+",age="+age+",leg="+leg);
    }

}
