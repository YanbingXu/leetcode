package arrayDemo1Homework;

import java.util.Scanner;

/**
 * 从键盘读入学生成绩，找出最高分，并输出学生成绩等级
 * 成绩>=最高分-10，A
 * 成绩>=最高分-20，B
 * 成绩>=最高分-30，C
 * 其余为D
 */
public class studentGrade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输出学生人数：");
        while(in.hasNextInt()){

            int stuNum = in.nextInt();
            System.out.println("请输入"+stuNum+"个成绩：");
            int[] stuGrade=new int[stuNum];
            int maxGrade=0;
            for (int i = 0; i < stuGrade.length; i++) {
                stuGrade[i]=in.nextInt();
                if(stuGrade[i]>maxGrade){
                    maxGrade=stuGrade[i];
                }
            }
            System.out.println("最高分是："+maxGrade);
            for (int j = 0; j < stuGrade.length; j++) {
                if(stuGrade[j]>=maxGrade-10){
                    System.out.println("student "+j+" score is "+stuGrade[j]+ " "+"grade is A");
                }else if(stuGrade[j]>=maxGrade-20){
                    System.out.println("student "+j+" score is "+stuGrade[j]+ " "+"grade is B");
                }else if(stuGrade[j]>=maxGrade-30){
                    System.out.println("student "+j+" score is "+stuGrade[j]+ " "+"grade is C");
                }else{
                    System.out.println("student "+j+" score is "+stuGrade[j]+ " "+"grade is D");
                }
            }

        }
    }
}
