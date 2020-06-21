package CommonUsedClass;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

/**
 * 其他常用类的使用：
 * 1。System
 * 2。Math
 * 3。BigDecimal
 */
public class OtherClassTest {
    @Test
    public void test(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version："+javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home："+javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name："+osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version："+osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name："+userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home："+userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir："+userDir);


    }

    @Test
    public void test2(){
        BigInteger bi = new BigInteger("124737848293948777572929309486773718848885747727378286929399492835827682672672773872993993393385729867986789279876986798278938384672638768727836897687923392039020586786749834");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//        System.out.println(bd.divide(bd2));//除不尽就会报错
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));//四舍五入
        System.out.println(bd.divide(bd2,25,BigDecimal.ROUND_HALF_UP));//保留15位小数


    }
}
