package vivo0604;

import java.util.ArrayList;
//import java.util.List;
/**
 * 查找在A数组中存在，B数组不存在的数据
 有以下三种方法
 总结 ：
 1.使用了循环里面的label
 2.使用了一个flag作为标志位
 3.最简单，使用了Set这个集合的remove(Collection)方法。
 */
public class test01 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8};
        int[] b={2,4,6,8};
        findDifferent(a,b);
    }

    private static void findDifferent(int[] a,int[] b ) {
        ArrayList list=new ArrayList();
        boolean flag;
        for(int i:a){
            flag=false;
            for(int j:b){
                if(i==j){
                    flag=true;
                }
            }
            if(flag!=true){
                list.add(i);
            }
        }
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }


}
