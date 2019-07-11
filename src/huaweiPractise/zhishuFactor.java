package huaweiPractise;


import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）

 最后一个数后面也要有空格

 详细描述：


 函数接口说明：

 public String getResult(long ulDataInput)

 输入参数：

 long ulDataInput：输入的正整数

 返回值：

 String



 输入描述:
 输入一个long型整数

 输出描述:
 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

 示例1
 输入
 180

 输出
 2 2 3 3 5
 */
public class zhishuFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = Long.parseLong(in.next());
        String result=getResult(num);
        System.out.println(result);
    }


    /**
     *
     * @param ulDataInput  思路就是i从2开始遍历到n，如果可以被i整除，n/i,是否能被i整除(i重新做循环)
     * @return
     */
    public static  String getResult(long ulDataInput){

        StringBuilder sb = new StringBuilder();
        long number = ulDataInput;

        while(number!=1){
            int i=2;          //重新赋值保证每次都从2开始遍历
            for(i=2;i<=number;i++){
                if(number%i==0){
                    sb.append(i).append(" ");
                    number/=i;
                    break;
                }
            }
        }
        return sb.toString();

    }
}
