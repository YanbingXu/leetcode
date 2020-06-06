package CommonUsedClass;

import org.junit.Test;

import java.util.Date;

/**
 * jdk8之前的日期时间API测试
 */
public class DateTimeTest {
    /*
    1.System类中的currentTimeMillis,此方法适用于计算时间差
     */
    @Test
    public void test(){
        long time = System.currentTimeMillis();//时间戳

    }

    /*
    java.util.Data类
            ｜---java.sql.Data类：对应着数据库类型中的日期类型变量
                    >如何实例化
                    >如何转换

    1。两个构造器的使用

    2。两个方法的使用
        >toString():显示当前的年月日时分秒
        >getTime():获取当前Date对象对应的毫秒数（时间戳）


     */
    @Test
    public void test2(){
        //构造器一：Date（）创建了一个对应当前时间的date对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        System.out.println(date1.getTime());//毫秒数


        //构造器二：Date（long time）创建指定毫秒数的date对象
        Date date2 = new Date(1591344322804L);
        System.out.println(date2);


        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(3428828910488L);
        System.out.println(date3);//2078-08-27

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一
//        Date date4 = new java.sql.Date(3428828910488L);//多态
//        java.sql.Date date5 = (java.sql.Date) date4;//强转

        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());



    }
}
