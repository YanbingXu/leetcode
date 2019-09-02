package huaweiPractise;


import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

 输入描述:
 输入一个正浮点数值

 输出描述:
 输出该数值的近似整数值

 示例1
 输入
 5.5

 输出
 6
 */
public class approximateNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //方法一 round函数 四舍五入
//        double num = Double.parseDouble(in.next());
//        int result = (int)Math.round(num);
//        System.out.println(result);

        double num = in.nextDouble();
        int i = (int) num;
        int result;
        if(num-i>=0.5){
            result = i+1;
        }else{
            result = i;

        }
        System.out.println(result);
   }
}
