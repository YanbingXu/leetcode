package CommonUsedClass;

import org.junit.Test;

import java.util.Arrays;

/**
 * 涉及到String类与其他结构的转换
 */
public class StringConvertMethod {
    /*
    复习：
    String与基本数据类型，包装类之间的转换
    String--->基本数据类型，包装类:调用包装类的静态方法
    基本数据类型，包装类--->String:调用String重载的valueOf（）
     */
    @Test
    public void test(){
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println(num);


        String str2 = String.valueOf(num);
        String str3 = num+"";
        System.out.println(str2==str3);
        System.out.println(str==str3);
        System.out.println(str == str2);


    }

    /*
    String 与 char[]的转换
    String -->char[]:调用String的toCharArray（）
    char[]--->String:调用String的构造器
     */
    @Test
    public void test2(){
        String str = "abc123";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }


        char[] arr = new char[]{'h','e','l','l','o'};
        String s = new String(arr);
        System.out.println(s);

    }




    /*
    String与字节数组byte[]的转换
    String -->byte[]:调用String的getBytes（）
    byte[] -->String：调用String的构造器

    编码：字符串-->字节
    解码：字节-->字符串

     */
    @Test
    public void test4(){
        String str = "abc123中国";//utf-8：一个汉字3个bytes
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        System.out.println("******************");
        String s = new String(bytes);
        System.out.println(s);

    }
}
