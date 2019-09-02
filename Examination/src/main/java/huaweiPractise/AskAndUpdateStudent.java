package huaweiPractise;

/**
 * 输入包括多组测试数据。
 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 学生ID编号从1编到N。
 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

 输出：对于每一次询问操作，在一行里面输出最高成绩.
 输入例子1:
 5 7
 1 2 3 4 5
 Q 1 5
 U 3 6
 Q 3 4
 Q 4 5
 U 4 5
 U 2 9
 Q 1 5
 输出例子1:
 5
 6
 5
 9
 */


import java.util.*;


public class AskAndUpdateStudent {
    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            String[] FirstLine = s.split("\\ ");
            int numStudent = Integer.parseInt(FirstLine[0]);
            int numOperate = Integer.parseInt(FirstLine[1]);
            //System.out.println(numOperate);

            //处理第二行，保存学生成绩
            s = in.nextLine();
            String[] SecondLine = s.split("\\ ");
            int[] stGrade = new int[numStudent];
            for(int i=0;i<numStudent;i++){
                stGrade[i] = Integer.parseInt(SecondLine[i]);
                //System.out.println(stGrade[i]);
            }


            //处理操作
            for(int j = 0;j<numOperate;j++){
                s = in.nextLine();
                String[] operate = s.split("\\ ");
                int from = Integer.parseInt(operate[1]);
                int to = Integer.parseInt(operate[2]);
                if(operate[0].equals("Q")){
                    //询问ID从A到B（包括A,B）的学生当中成绩最高的是多少

                    System.out.println(SortMax(from,to,stGrade));

                }else if(operate[0].equals("U")){
                    //这是一条更新操作，要求把ID为A的学生的成绩更改为B。
                    stGrade[from-1]=to;
                }
            }

        }

    }

    private static int SortMax(int from, int to, int[] a){
        if(from>to){
            return SortMax(to,from,a);
        }
        int max = a[from-1];
        for(int i =from;i<to;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;

        }

    }

