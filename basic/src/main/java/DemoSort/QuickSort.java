package DemoSort;

import java.util.Arrays;

/**
 * 时间复杂度   平均        最好     最坏
 *             O(nlogn) O(nlogn) O(n^2)
 * 空间复杂度   O（nlogn）
 * 不稳定
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1, 5, 9, 7, 4, 3, 8};
        System.out.println(Arrays.toString(arr));
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void quickSort(int start, int end, int[] arr) {
        //首先只有再start<end的情况下才需要排序
        if (start < end) {
            //选择第一个元素为基准数
            int stard = arr[start];
            //定义两个会移动的下标
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= stard) {
                    high--;
                }
                //不然就进行一个赋值
                arr[low] = arr[high];
                //接下去比较小的
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                //不满足就赋值
                arr[high] = arr[low];
            }
            arr[low] = stard;
            //对小的那一部分再来排序
            quickSort(start, low, arr);
            //对大的那一部分递归排序
            quickSort(low + 1, end, arr);

        }
    }
}



