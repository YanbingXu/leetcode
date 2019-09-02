package util;

import java.util.Arrays;

/**
 * 封装一个面向对象的数组
 */
public class ObjectOrientedArray {
    private int[] elements ;

    //构造函数
    public ObjectOrientedArray(){
        elements=new int[0];
    }
    //获取数组的长度
    public int size(){
        return elements.length;
    }

    //在数组末尾添加一个元素
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        newArr[elements.length]=element;
        elements=newArr;
    }

    //直接打印出数组的元素
    public void  show(){
        System.out.println(Arrays.toString(elements));
    }

    //删除一个元素
    public void delete(int index){
        int[] newArr = new int[elements.length-1];
        //边界判断
        if(index<0 || index>elements.length-1){
            throw new RuntimeException("下标溢出");
        }

        for(int i =0;i<newArr.length;i++){
            if(i<index){
                newArr[i]=elements[i];
            }else{
                newArr[i]=elements[i+1];
            }
        }
        elements=newArr;
    }

    //获取某个元素
    public int get(int index){
        return elements[index];
    }
    //在某一位置插入一个元素
    public void insert(int index,int element){

        int[] newArr = new int[elements.length+1];
        for(int i=0;i<newArr.length;i++){
            if(i<index){
                newArr[i]=elements[i];
            }else if(i==index){
                newArr[i]=element;
            }else{
                newArr[i]=elements[i-1];
            }
        }
        elements=newArr;

    }
    //线性查找
    public int LinearSearch(int target){
        for(int i =0;i<elements.length;i++){
            if (target==elements[i]){
                return i;
            }

        }
        return -1;
    }
    //二分查找
    public int BinarySearch(int target){
        //初始化开始位置和结束位置和中间位置
        int begin=0;
        int end = elements.length-1;
        int mid = (begin+end)/2;

        //循环查找
        while (true){
            //如果target不在数组中
            if(begin>=end){
                return -1;
            }
            if(target==elements[mid]){
                return mid;
            }
            else if(target<elements[mid]){
                end=mid-1;

            }
            else{
                begin = mid+1;
            }
            mid=(begin+end)/2;

        }

    }





}
