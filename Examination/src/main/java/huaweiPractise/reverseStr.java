package huaweiPractise;

import java.util.Scanner;

/**
 * 题目描述
 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 输入描述:
 输入N个字符

 输出描述:
 输出该字符串反转后的字符串

 示例1
 输入
 abcd

 输出
 dcba
 */
public class reverseStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }


    }
}
