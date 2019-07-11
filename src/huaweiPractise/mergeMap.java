package huaweiPractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

 输入描述:
 先输入键值对的个数
 然后输入成对的index和value值，以空格隔开

 输出描述:
 输出合并后的键值对（多行）

 示例1
 输入
4
0 1
0 2
1 2
3 4


 输出
 0 3
 1 2
 3 4
 */
public class mergeMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());  //后面用了nextline的这边就也要用nextline不然计数不对
        int[] finalArr = new int[num];
        while(in.hasNextLine()){
            while(num>0){
                String str = in.nextLine();
                String[] split = str.split(" ");
                finalArr[Integer.parseInt(split[0])]+=Integer.parseInt(split[1]);
                num--;
            }


            for (int i = 0; i < finalArr.length; i++) {
                if(finalArr[i]!=0){                          //这里有问题啊，如果输入的键值对就有零怎么办
                    System.out.println(i+" "+finalArr[i]);
                }

            }
        }
    }
}



