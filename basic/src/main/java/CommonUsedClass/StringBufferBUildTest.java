package CommonUsedClass;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 */
public class StringBufferBUildTest {
    /*
    string，stringbuffer，stringbuilder的异同：
    1。string：不可变的字符序列，底层用char[]存储
    2。stringBuffer：可变的字符序列，线程安全，效率偏低，底层用char[]存储
    3。stringBuilder：可变的字符序列，jdk5.0新增的，线程不安全，效率高，底层用char[]存储

    源码分析：
    String str = new String（）；//char[] value = new char[0];
    String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16];

    //问题1：sb2.length()是多少？------3
    //问题2：扩容问题   如果要添加的数据底层数组存不下了，就需要扩容底层数组
                      默认情况下扩容为原来的2倍+2，同时将原有数组中的元素复制到新的数组中


                      指导意义：开发中建议StringBuffer（int capacity）

      时间效率：StringBuilder>StringBuffer>String

     */


    /*
    StringBuffer常用方法：
    总结：
    （方法链，sb1.append().append()）
    增：append
    删:delete
    改:setCharAt/replace
    查:charAt
    插:insert
    长度:length
    遍历:for + charAt/toString

     */
    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);//append:字符串拼接
        sb1.append("1");
        System.out.println(sb1);
        //sb1.delete(2,4);//delete:字符串删除，左闭右开
        //System.out.println(sb1);

//        sb1.replace(2,4,"hello");//替换
//        System.out.println(sb1);

//        sb1.insert(2,false);//插入
//        System.out.println(sb1);
//        System.out.println(sb1.length());//10 false=5个字符

//        System.out.println(sb1.reverse());//字符串反转

//        System.out.println(sb1.indexOf("abc"));//字符串所在的第一位索引值

//        System.out.println(sb1.substring(1,4));//截取该字符串的子串

//        System.out.println(sb1.charAt(1));//某一索引位置的字符

//        sb1.setCharAt(1,'m');//将某一索引处的字符改为另一字符
//        System.out.println(sb1);


    }
}
