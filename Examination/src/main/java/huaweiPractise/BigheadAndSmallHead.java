package huaweiPractise;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
/**
 * 题目描述：第一行为数字n，表述后续输入的字符串有多少个编码组
 * 第二行为编码字符串
 * 例如：
 * 2
 * 0abcdefgh1abcdefgh
 *
 * 输出：
 * hgfedcba abcdefgh
 */
public class BigheadAndSmallHead {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        decoder(n,s);

    }

    public static void decoder(int n,String s){
        String res1 = null;
        String res2 = null;
        for(int i=0;i<s.length();i+=9){

            if(s.charAt(i)=='0'){
                res1=s.substring(i+1,i+9);
                StringBuffer newStr = new StringBuffer(res1);
                res1 = newStr.reverse().toString();
                System.out.print(res1+' ');

            }
            else{
                res2=s.substring(i+1,i+9);
                System.out.println(res2+' ');

            }
        }
        System.out.println();
    }
}
