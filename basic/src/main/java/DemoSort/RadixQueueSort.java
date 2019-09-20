package DemoSort;

import demoQueue.MyQueue;

import java.util.Arrays;

public class RadixQueueSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23,6,189,45,9,287,56,1,798,34,65,652,5};
        System.out.println(Arrays.toString(arr));
        radixQueueSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void radixQueueSort(int[] arr){
        //先找出数组中最大的数字的位数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //新建一个存放数据的队列
        MyQueue[] temp = new MyQueue[10];
        //为temp数组赋值
        for (int h = 0; h < temp.length; h++) {
            temp[h] = new MyQueue();
        }

        //循环遍历的次数
        for(int i = 0,n=1; i<maxLength;i++,n*=10) {
            //遍历整个arr进行操作,得到每个数的各个位的数字(余数)
            for (int i1 = 0; i1 < arr.length; i1++) {
                int ys = arr[i1] / n % 10;
                //根据个位数字放到对应的容器中
                temp[ys].add(arr[i1]);
            }

            int index = 0;
            //依次取出各个容器中的数字
            for (int t = 0; t < temp.length; t++) {
                //如果队列不为空，就要取出
                while (!temp[t].isempty()) {
                    arr[index++] = temp[t].poll();
                }
            }
        }



    }
}
