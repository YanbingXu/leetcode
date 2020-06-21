package enumTest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用enum关键字定义枚举类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);


//        System.out.println(Season1.class.getSuperclass());//得到他的父类class java.lang.Enum
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));


        summer.show();
    }
}

interface info{
    void show();
}


//使用enum关键词创建枚举类
enum Season1 implements info{
    //1.提供当前枚举类的对象，多个对象之间用"，"隔开，末尾对象"；"结束
    SPRING("春天","春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里");  //情况二
        }
    },
    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁静的夏天");

        }
    },
    AUTUMN("秋天","秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");

        }
    },
    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");

        }
    };

    //2。声明season对象的属性:用private final 来修饰，表示不可变
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4，其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//情况一
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
