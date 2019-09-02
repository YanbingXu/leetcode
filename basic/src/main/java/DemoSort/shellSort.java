package DemoSort;

import java.util.Arrays;

public class shellSort {
    public static void main(String[] args) {
        int[] arr =new int[]{3,1,5,2,6,8,9,3,1,0};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort(int[] arr){
        int k=1;
        //遍历步长
        for(int d=arr.length/2;d>0;d/=2){
            //遍历每一组的第一个元素
            for(int i=d;i<arr.length;i++){
                //遍历本组中所有元素
                for(int j=i-d;j>=0;j-=d){
                    if(arr[j]>arr[j+d]){
                        int temp=arr[j];
                        arr[j]=arr[j+d];
                        arr[j+d]=temp;
                    }
                }
            }
            System.out.println("第"+k+"次减半步长的结果"+Arrays.toString(arr));
            k++;
        }

    }
}
