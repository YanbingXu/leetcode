package AnnotationTest;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用
 * 1。理解annotation
 * 1）jdk5.0新增的功能
 * 2）annotation就是代码里的特殊标志，这些标志可以在编译、类加载、运行时被读取，并执行相应的处理
 * 通过使用annotation，程序员可以在不改变原有代码逻辑的前提下，在源文件中嵌入一些补充信息
 * 3）在javase中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在javaee/andriod中
 * 注解占据了更重要的角色，例如用来配置应用程序中的任何切面，代替javaee旧版中遗留的复杂代码和
 * xml配置
 *
 *
 * 2。annotation的使用实例
 * 实例一：文档注释
 *
 * 实例二：jdk内置三个基本注解
 * @override 限定重写父类方法
 * @depricated  用于表示所修饰额元素已过时
 * @suppressWarnings 抑制编译器警告
 *
 * 实例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照supressWarnings定义
 * 1）注解声明为@interface
 * 2)内部是成员变量，但是形式类似一个方法，String value（）
 * 3）可以指定成员的默认值，使用default定义
 * 4）如果自定义注解没有成员，表明是一个标识作用
 *
 *
 * 如果注解有成员，使用注解时需要指定成员值
 * 自定义注解必须配上注解的信息处理流程（反射）才有意义
 * 自定义注解通常都会指明两个元注解，retention和target
 *
 *
 * 4.jdk提供的4种元注解
 *   元注解：对现有注解进行解释说明的注解
 *   1）Retention：指定所修饰的annotation的生命周期，source、class（默认行为）、runtime
 *                  只有声明为runtime生命周期的注解，才能通过反射获取
 *   2）Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 *   ******************出现频率较低**************************************
 *   3）Document：标示所修饰的注解在被javadoc解析时被保留下来，
 *   4）Inherited：被他修饰的annotation将具有继承性
 *
 *5.通过反射来获取注解信息
 *
 *
 *6.jdk8中关于注解的新特性：
 *  1。可重复注解 1)在myannotation声明@repeatable，成员值为myannotations.class
 *              2）myannotation的target和retention等元注解必须和myannotations相同
 *  2。类型注解
 *  ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中（如：范形声明）
 *  ElementTYpe.TYPE_USE表示该注解能写在使用类型的任何语句中
 */
public class annotationTest {
    public static void main(String[] args) {
        person p = new student();
        p.walk();

        @SuppressWarnings("unused")
        int num = 10;
    }

    @Test
    public void testGetAnnotation(){//为什么这里不会跳出继承的annotation？----Rentention一定要写成runtime才能用反射
        Class<student> studentClass = student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}


//jdk8之前的可重复注解办法
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value = "abc")})
//jdk8之后的可重复注解
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class person{
    private String name;
    private int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }


}

interface info{
    void show();
}

class student extends person implements info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }

}

//类型注解例子
class Generic<@MyAnnotation T>{

    ArrayList<@MyAnnotation String> list = new ArrayList<>();

}