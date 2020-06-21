package AnnotationTest;

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
 *
 */
public class annotationTest {
    public static void main(String[] args) {
        person p = new student();
        p.walk();

        @SuppressWarnings("unused")
        int num = 10;
    }
}

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