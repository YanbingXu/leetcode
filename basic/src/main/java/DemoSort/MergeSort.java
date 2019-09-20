package DemoSort;


import java.util.Arrays;

/**
 * 时间复杂度   平均     最好        最坏
 *          O(nlogn)   O(nlogn)  O(nlogn)
 * 空间复杂度   O（1）
 * 稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(arr));
        MergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }

    public static void MergeSort(int[] arr, int low, int high) {
        int middle = (low + high) / 2;
        //递归结束条件
        if (low < high) {
            //先排左边
            MergeSort(arr, low, middle);
            //再排右边
            MergeSort(arr, middle + 1, high);
            //最后归并
            Merge(arr, low, middle, high);
        }


    }

    public static void Merge(int[] arr, int low, int middle, int high) {
        //先定义一个临时数组进行存储
        int[] temp = new int[high - low + 1];
        //定义两个移动的指针
        int i = low;
        int j = middle + 1;
        //定义一个temp的索引
        int index = 0;
        //指针移动的条件就是i再low到middle，j再middle+1到high
        while (i <= middle && j <= high) {
            //i小就添加i的数据
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;

            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;

        }
        //处理剩下的数据
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        //把temp的内容复制到arr中
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[i1 + low] = temp[i1];
        }


    }
}
