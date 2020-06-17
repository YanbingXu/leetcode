package CommonUsedClass;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk8中日期时间API测试
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量问题
        Date date = new Date(2020, 9, 8);
        System.out.println(date);//Fri Oct 08 00:00:00 CST 3920

        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);//Tue Sep 08 00:00:00 CST 2020
    }

    /*
    LocalDate,LocalTime,LocalDateTime的使用
    说明：
    1。LocalDateTime的使用频率较高
    2。类似与calendar

     */
    @Test
    public void test1(){
        //now：获取当前时间
        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();


        //2020-06-07
        //17:14:26.779
        //2020-06-07T17:14:26.780
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        //of():设定指定的年月日时分秒，无偏移量
        LocalDateTime localDateTime1 = localDateTime.of(2020, 10, 25, 13, 14, 25);
        System.out.println(localDateTime1);


        //getXXX（）
        System.out.println(localDateTime.getDayOfMonth());//获取今天是当月第几天
        System.out.println(localDateTime.getDayOfWeek());//SUNDAY
        System.out.println(localDateTime.getMonth());//JUNE
        System.out.println(localDateTime.getMonthValue());//6
        System.out.println(localDateTime.getMinute());//20

        //withXXX：设置相关的属性
        LocalDateTime localDateTimeNew = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTimeNew);//体现了不可变性


        LocalDateTime localDateTime2 = localDateTime.withHour(4);//设置为4点
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //plusXXX：加（不可变性）
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);//在现有时间基础上加了3个月
        System.out.println(localDateTime3);


        //minusXXX：减（不可变性）
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);//减4天
        System.out.println(localDateTime4);


    }

    /*
    Instant的使用：
    类似与java.util.Date类
     */
    @Test
    public void InstantTest(){
        //实例化方式 now（）
        Instant instant = Instant.now();//2020-06-07T09:33:51.228Z本初子午线的时间
        System.out.println(instant);

        //根据时区添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970（UTC）年开始的毫秒数--->getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);

        //通过给定的毫秒数获取Instant实例--->Date(毫秒数)
        Instant instant1 = Instant.ofEpochMilli(1598764728829L);
        System.out.println(instant1);
    }


    /*
    DateTimeFormatter:格式化或解析日期，时间
    类似与SimpleDateFormat
     */
    @Test
    public void testDateTimeFormatter(){
        //实例化方法
        //1。预定义的标准格式
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String format = isoLocalDateTime.format(now);
        System.out.println(now);
        System.out.println(format);

        //解析：
        TemporalAccessor parse = isoLocalDateTime.parse("2020-06-08T16:43:24.34");
        System.out.println(parse);

        //2。本地化方式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);//20-6-8 下午6:26


        //3。自定义的格式
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format2);//2020-06-08 06:32:52
        //解析
        TemporalAccessor parse1 = dateTimeFormatter1.parse("2020-06-08 06:32:52");
        System.out.println(parse1);


    }
}
