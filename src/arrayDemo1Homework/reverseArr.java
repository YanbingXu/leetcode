package arrayDemo1Homework;

import java.util.Arrays;

public class reverseArr {
    public static void main(String[] args) {
        String[] arr = new String[]{"JJ","DD","MM","BB","GG","AA"};

        //数组的复制（区别于数组的赋值，arr1=arr2）
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=arr[i];
        }

        //数组的反转
        for (int i = 0; i < arr.length/2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }
}
