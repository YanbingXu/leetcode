package arrayDemo1Homework;

/**
 *
 * 4.对象数组题目：
 * 定义类student。包含三个属性：学号number，年级state，成绩score。创建20个学生对象，学号1-20
 * 年级和成绩都由随机数给定。
 * 问题一：打印出3年级的学生信息
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
 *
 *
 */
public class objectArrStudentGrade {
    public static void main(String[] args) {
        student[] stus = new student[20];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new student();
            stus[i].number = i+1;
            stus[i].state = (int)(Math.random()*(6-1+1)+1);
            stus[i].score = (int)(Math.random()*(100-0+1)+0);


        }

        //遍历显示
        for (int i = 0; i < stus.length; i++) {
            stus[i].show();
        }

        System.out.println("******************");
        //问题一：打印出3年级的学生信息
        for (int i = 0; i < stus.length; i++) {
            if(stus[i].state==3){
                stus[i].show();
            }
        }

        System.out.println("***********");
        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
        for(int i = 0;i<stus.length-1;i++){
            for(int j=0;j<stus.length-1-i;j++){
                if(stus[j].score>stus[j+1].score){
                    student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = temp;

                }

            }
        }

        //遍历显示
        for (int i = 0; i < stus.length; i++) {
            stus[i].show();
        }


    }
}

class student{
    //属性
    int number; //学号
    int state; //年级
    int score; //成绩

    //方法

    //1.打印的方法
    public void show(){
        System.out.println("学号是："+number+",年级是："+state+",成绩是："+score);
    }

}


