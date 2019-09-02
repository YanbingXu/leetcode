package DemoSort;

import java.util.Arrays;

/**
 * 8种排序算法分为5大类
 * 1.交换排序：冒泡和快速
 * 2.插入排序：直接插入排序和希尔排序
 * 3.选择排序：简单选择排序和堆排序
 * 4.归并排序
 * 5.基数排序
 */

public class testSort1 {
    public static void main(String[] args) {
        int[] arr = new int[] {3,6,2,6,1,4,7,9,0,8};
        System.out.println(Arrays.toString(arr));
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * 3,6,2,6,1,4,7,9,0,8共比较n-1轮
     *
     */
    public static void BubbleSort(int[] arr){
        //控制比较的轮数
        for(int i =0;i<arr.length-1;i++){
            //控制一轮比较的次数
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
