package huaweiPractise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 输入描述:
 连续输入字符串(输入2次,每个字符串长度小于100)

 输出描述:
 输出到长度为8的新字符串数组

 示例1
 输入
 abc
 123456789

 输出
 abc00000
 12345678
 90000000
 */
public class SplitString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
//        while(in.hasNextLine()){
//            String s1 = in.nextLine(); //这里要修改 不然感觉好愚蠢（此处已知2次，若次数未知呢）
//            String s2 = in.nextLine();
//            operateStr(s1);
//            operateStr(s2);
//
//        }
        while (in.hasNext()) {
            operateStr(in.nextLine());   //无法利用hasnext来做count，count要不还是while（true）把
        }
    }

//        StringBuilder stringbuilder = new StringBuilder();
//        while(true){                                        //用这个方法可以从while循环里跳出来
//            String text = in.nextLine().trim();
//            if ("".equals(text))
//            {
//                break;
//            }
//            stringbuilder.append(text);
//        }
//        System.out.println(stringbuilder.toString());

//        while(in.nextLine()!=null && !in.nextLine().equals("")){
//            String text = in.nextLine();
//            System.out.println(text);//为什么不操作（因为是下下个）
//        }
//        System.out.println("end of while");

    public static void operateStr(String s){
        if(s.length()>8){   //不能是>=，不然会多输出一行00000000
            System.out.println(s.substring(0,8));
            s=s.substring(8);
            operateStr(s);
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            for(int i=0;i<8-s.length();i++){
                sb.append('0');

            }
            System.out.println(sb);
        }

    }
}
