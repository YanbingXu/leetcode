package huaweiPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

 输入描述:
 输入一个int型整数

 输出描述:
 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

 示例1
 输入
 9876673

 输出
 37689
 */
public class ExtractNoRepeatingInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=chars.length-1;i>=0;i--){
            if(!temp.contains(chars[i]-'0')){
                temp.add(chars[i]-'0');
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i));
        }

    }
}
