package huaweiPractise;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

 输入描述:
 输入一个有字母和数字以及空格组成的字符串，和一个字符。

 输出描述:
 输出输入字符串中含有该字符的个数。

 示例1
 输入
 复制
 ABCDEF A
 输出
 复制
 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class StrNumCalculate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char target = in.next().charAt(0);

        //System.out.println(Character.toUpperCase(character));

        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==Character.toUpperCase(target)||str.charAt(i)==Character.toLowerCase(target)){
                count++;

            }
        }
        System.out.println(count);
    }
}
