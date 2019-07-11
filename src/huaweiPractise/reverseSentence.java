package huaweiPractise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *输入描述:
 将一个英文语句以单词为单位逆序排放。

 输出描述:
 得到逆序的句子

 示例1
 输入
 复制
 I am a boy
 输出
 复制
 boy a am I
 */
//public class reverseSentence {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            String[] next = in.nextLine().split(" ");
//            for (int i = next.length - 1; i >0; i--) {
//                System.out.print(next[i]+" ");
//            }
//            System.out.print(next[0]);
//        }
//
//    }
//}

//method 2 利用stringbuilder真的能快好多
public class reverseSentence{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        //System.out.println(sentence);
        System.out.println(reverse(sentence));

    }

    /**
     *
     * @param sentence
     * @return
     */
    public static String reverse(String sentence){
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder(split.length);
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        //sb.append(split[0]);
        return sb.toString();

    }
}
