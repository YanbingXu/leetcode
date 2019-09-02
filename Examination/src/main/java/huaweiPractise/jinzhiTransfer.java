package huaweiPractise;



import java.util.Scanner;

/**
 * 题目描述
 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

 输入描述:
 输入一个十六进制的数值字符串。

 输出描述:
 输出该数值的十进制字符串。

 示例1
 输入
 0xA
 输出
 10
 */
public class jinzhiTransfer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next().substring(2);
            int temp = 0;
            int result=0;

            for(int i=0;i<str.length();i++){
                //拿到str中的每一个值 charat
                char letter = str.charAt(i);

                if(letter>='0'&&letter<='9'){
                    temp = letter-'0';

                }
                else if(letter>='A'&&letter<='Z'){
                    temp = letter-'A'+10;

                }
                int mi = str.length()-1-i;
                result+=temp*Math.pow(16,mi);

            }
            System.out.println(result);
        }
    }
}


