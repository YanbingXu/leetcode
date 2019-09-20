package DemoSort;

import java.util.Arrays;

/**
 * 时间复杂度   平均     最好  最坏
 *             O(n^2)   O(n)  O(n^2)
 * 空间复杂度   O（1）
 * 稳定
 */

public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,4,1,7,5,9,0,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr){
        //从第二个元素开始向后遍历
        for (int i=1;i<arr.length;i++){
            //如果这一个数比前一个数小
            if(arr[i]<arr[i-1]){
                //定义一个临时变量用来存放当前的数
                int temp = arr[i];
                int j;
                //依次向前比较，所以前面的数依次往后挪位置
                for(j =i-1;j>=0&&temp<arr[j];j--){
                    arr[j+1]=arr[j];
                }
                //不满足条件之后就赋值给它后一个元素
                arr[j+1]=temp;
            }
        }
    }
}
