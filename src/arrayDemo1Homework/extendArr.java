package arrayDemo1Homework;

import java.util.Arrays;

/**
 * 扩展一个长度为6的int形数组，要求数组元素的值都在1-30之间，且是随机赋值，同时要求元素的值各不相同
 */
public class extendArr {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random()*30+1);

            for(int j =0;j<i;j++){
                if(arr[j]==arr[i]){
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
