package huaweiPractise;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 一行字符串，非空，长度小于5000。

 输出描述:
 整数N，最后一个单词的长度。

 示例1
 输入
 复制
 hello world
 输出
 复制
 5
 */
public class FinalStrLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        //System.out.println(Arrays.toString(s));
        System.out.println(s[s.length-1].length());


    }
}
