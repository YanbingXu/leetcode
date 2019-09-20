package DemoSort;

import java.util.Arrays;

/**
 * 时间复杂度   平均     最好  最坏
 *             O(n^2)   O(n^2)  O(n^2)
 * 空间复杂度   O（1）
 * 不稳定
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,3,5,7,8,0,9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        //i就是选择的次数，每个元素都要被选择到
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //j就是标记数以后的所有元素
            for(int j=i+1;j<arr.length;j++){
                //如果后面有比标记数更小的数字，就挪标记
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }

            //如果标记已经不是最开始的那一个，就把最小的挪到标记数那个位置
            if(i!=minIndex){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }
}
