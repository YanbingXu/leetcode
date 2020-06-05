package CommonUsedClass;

import org.junit.Test;

/**
 * string的使用
 */
public class StringTest {
    /*
        String：字符串，用一对""引起来表示
        1。String声明为final，不可被继承
        2。String实现了Serializable接口：表示字符串是支持序列化的
                 实现了Comparable接口：表示String可以比较大小
        3。String内部定义了final char[] value用于存储字符串数据
        4。String代表不可变的字符序列。简称：不可变性
                体现：1）当对字符串重新赋值，需要重写指定内存区域赋值，不能使用原有的value赋值
                     2）对现有字符串进行链接操作时，也需要重新指定内存区域赋值，不能使用原有的value赋值
                     3)当调用string的replace方法时，修改字符或字符串时，也必须重新指定内存区域赋值
        5。通过字面量（区别与new）的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中
        6。字符串常量池中是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量
        String s2 = "abc";


        System.out.println(s1 == s2);//同一地址

        s1="hello";

        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        System.out.println("************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc


    }

    /*
        String的实例化方式
        方式一：通过字面量定义的方式
        方式二：通过new+构造器方式

        面试题：String s = new String("abc");方式创建对象，创建了几个对象？
            答：2个，一个是堆空间中new创建的对象，另一个是char型数组对应的常量池中的数据（abc）

     */
    @Test
    public void test2(){
        //此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1="javaEE";
        String s2="javaEE";

        //此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");


        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false


        System.out.println("****************");
        Person p1 = new Person("tom", 12);
        Person p2 = new Person("tom", 12);
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name==p2.name);//true

        p1.name = "jerry";
        System.out.println(p2.name);//tom
        System.out.println(p1.name);//jerry


    }


    /*
       字符串拼接结论：
       1）常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
       2）只要其中有一个是变量，结果就在堆中
       3）如果拼接的结果调用intern（），返回值就在常量池中。

     */
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1+s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false

        System.out.println(s3 == s7);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false


        String s8 = s5.intern();//返回值得到的s8使用的常量池中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);//true


    }

    /*
    String的一些常用方法，
    length（），indexof（），charAt（），toUpperCase(),substring(),isEmpty(),
    compareTo(),trim()等等常用方法不做实例
    替换：
    replace（）
    replaceAll（正则）
    replaceFirst（）:只替换第一个
    匹配：
    boolean matches（String regex）告知此字符串是否匹配给定的正则表达式
    切片：
    String[] split(String regex)根据给定正则表达式的匹配拆分此字符串

     */
    @Test
    public void test4(){
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换为逗号，把开头和结果的逗号去掉
        String str2 = str.replaceAll("\\d+", ",").replaceAll("^,|,$","");
        System.out.println(str2);


        String str3 = "12345";
        //判断字符串是否全部由数字组成
        boolean matches = str3.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是杭州的固定电话
        boolean matches1 = tel.matches("0571-\\d{7,8}");//有7-8位的数字
        System.out.println(matches1);

        System.out.println("*************************");
        String str4 = "hello|world|java";
        String[] split = str4.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }


    }

}
