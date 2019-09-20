package DemoSort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23,6,189,45,9,287,56,1,798,34,65,652,5};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void radixSort(int[] arr){
        //先找出数组中最大的数字的位数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //新建一个存放数据的二维数组
        int[][] temp = new int[10][arr.length];
        //新建一个存放每一个容器中放了多少数据的一维数组
        int[] count = new int[arr.length];

        //循环遍历的次数
        for(int i = 0,n=1; i<maxLength;i++,n*=10) {
            //遍历整个arr进行操作,得到每个数的各个位的数字(余数)
            for (int i1 = 0; i1 < arr.length; i1++) {
                int ys = arr[i1] / n % 10;
                //根据个位数字放到对应的容器中
                temp[ys][count[ys]++] = arr[i1];
            }

            int index = 0;
            //依次取出各个容器中的数字
            for (int t = 0; t < count.length; t++) {
                //如果count中的内容不等于零，就要取出
                if (count[t] != 0) {
                    //遍历取出并放到原来的arr数组中
                    for (int k = 0; k < count[t]; k++) {
                        arr[index++] = temp[t][k];
                    }

                }
                //取完了之后要把count[t]中置0方便下一次操作
                count[t] = 0;
            }
        }



    }
}
