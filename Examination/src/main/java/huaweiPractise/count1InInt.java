package huaweiPractise;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 题目描述
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

 输入描述:
 输入一个整数（int类型）

 输出描述:
 这个数转换成2进制后，输出1的个数

 示例1
 输入
 5

 输出
 2
 */
public class count1InInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count=0;
        ArrayList<Integer>arr = new ArrayList<>();
        while(num!=0){
            arr.add(num%2);
            num=num/2;
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            if(arr.get(i)==1){
                count++;
            }
        }
        System.out.println(count);

    }
}
