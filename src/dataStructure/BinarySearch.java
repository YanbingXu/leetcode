package dataStructure;

public class BinarySearch {
    public static void main(String[] args) {
        //目标数组
        int[] num = new int[]{1,2,3,4,5,6,7,8,9};
        //初始化开始位置和结束位置和中间位置
        int begin=0;
        int end = num.length-1;
        int mid = (begin+end)/2;
        //设定target
        int target = 1;
        //初始化要输出的index
        int index = -1;


        //循环查找
        while (true){
            //如果target不在数组中
            if(begin>=end){
                index=-1;
            }
            if(target==num[mid]){
                index = mid;
                break;
            }
            else if(target<num[mid]){
                end=mid-1;

            }
            else{
                begin = mid+1;
            }
            mid=(begin+end)/2;

        }
        System.out.println(index);
    }
}
