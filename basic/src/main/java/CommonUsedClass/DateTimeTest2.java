package CommonUsedClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8之前的日期时间API测试
 * 1。System类中的currentTimeMillis（）
 * 2。java.util.Date和java.sql.Date
 * 3。SimpleDateFormat
 * 4。calendar
 */
public class DateTimeTest2 {
    /*
    SimpleDateFormat使用：对日期Date类的格式化和解析
    1。两个操作
        1）格式化：日期--->指定格式字符串
        2）解析：指定格式字符串--->日期
    2。实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        System.out.println(date);//Sun Jun 07 15:46:28 CST 2020


        String format = simpleDateFormat.format(date);
        System.out.println(format);//20-6-7 下午3:46


        System.out.println("***************************");

        //解析
        String str = "20-6-7 下午3:46";//被解析的字符串其实有格式要求
        Date date1 = simpleDateFormat.parse(str);//记得处理异常
        System.out.println(date1);

        System.out.println("***************************");


        //**********按照指定的方式进行格式化和解析：构造器选指定格式******************

        //格式化
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");//pattern 参考API
        //2020-06-07 03:55:07(年-月-日 时：分：秒)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//pattern 参考API
        String format1 = sdf.format(date);
        System.out.println(format1);

        //解析:要求字符串必须符合simpledateformat的识别的格式（通过构造器参数体现）
        Date parse = sdf.parse("2020-06-07 03:55:07");
        System.out.println(parse);


    }


    /*
    练习：字符串"2020-09-08"转换为java.sql.date
     */
    @Test
    public void testExer() throws ParseException {
        String str = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(str);
//        System.out.println(parse);

        java.sql.Date date = new java.sql.Date(parse.getTime());//使用带参构造器
        System.out.println(date);

    }

    /*
    Calendar日历类（抽象类）的使用

     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：调用其静态方法Calendar.getInstance（）
        //方式二：创建其子类（GregorianCalendar）的对象
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());//对象来自于这个类class java.util.GregorianCalendar

        //2.常用方法
        //get（filed）
        int days = instance.get(Calendar.DAY_OF_MONTH);//获取一下今天是这个月的第几天（day_of_month）
        System.out.println(days);

        //set()
        instance.set(Calendar.DAY_OF_MONTH,22);
        days = instance.get(Calendar.DAY_OF_MONTH);//set今天是这个月的第几天（day_of_month）
        System.out.println(days);


        //add()
        instance.add(Calendar.DAY_OF_MONTH,3);
        days = instance.get(Calendar.DAY_OF_MONTH);//今天是这个月的第几天,加amount
        System.out.println(days);


        //getTime()：日历类--->date对象
        Date time = instance.getTime();
        System.out.println(time);


        //setTime():date对象--->日历类
        Date date = new Date();//date:今天
        instance.setTime(date);
        System.out.println(instance.getTime());
    }

}
