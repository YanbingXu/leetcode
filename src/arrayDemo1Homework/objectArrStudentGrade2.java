package arrayDemo1Homework;

/**
 *
 * 4.对象数组题目：
 * 定义类student。包含三个属性：学号number，年级state，成绩score。创建20个学生对象，学号1-20
 * 年级和成绩都由随机数给定。
 * 问题一：打印出3年级的学生信息
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
 *
 * 次代码是对上一版本代码的改进，将操作数组的代码封装进方法中
 *
 */
public class objectArrStudentGrade2 {
    public static void main(String[] args) {
        student1[] stus = new student1[20];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new student1();
            stus[i].number = i+1;
            stus[i].state = (int)(Math.random()*(6-1+1)+1);
            stus[i].score = (int)(Math.random()*(100-0+1)+0);


        }

        //要调用下面的方法就要先创建一个对象
        objectArrStudentGrade2 test = new objectArrStudentGrade2();

        //遍历学生数组
        test.print(stus);
        System.out.println("******************");

        //问题一：打印出3年级的学生信息
        test.searchState(stus,3);
        System.out.println("***********");

        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
        test.print(stus);
        System.out.println("&&&&&&&&&&&");
        test.bubbleSort(stus);
        //遍历显示
        test.print(stus);


    }

    /**
     *
     * @param stus 要遍历显示的数组
     */
    public void print(student1[] stus){
        //遍历显示
        for (int i = 0; i < stus.length; i++) {
            stus[i].show();
        }

    }

    /**
     *
     * @param stus 处理的学生数组
     * @param state 查找指定的年级
     */
    public void searchState(student1[] stus,int state){
        //问题一：打印出3年级的学生信息
        for (int i = 0; i < stus.length; i++) {
            if(stus[i].state==state){
                stus[i].show();
            }
        }

    }

    /**
     *
     * @param stus 给student1数组排序，冒泡排序
     */
    public void bubbleSort(student1[] stus){
        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
        for(int i = 0;i<stus.length-1;i++){
            for(int j=0;j<stus.length-1-i;j++){
                if(stus[j].score>stus[j+1].score){
                    student1 temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = temp;

                }

            }
        }
    }
}

class student1{
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


