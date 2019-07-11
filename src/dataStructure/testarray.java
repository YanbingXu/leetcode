package dataStructure;

import array.util.ObjectOrientedArray;

public class testarray {
    public static void main(String[] args) {
        //创建一个可变数组
        ObjectOrientedArray arr = new ObjectOrientedArray();
        System.out.println(arr.size());
        arr.add(1);
        arr.add(2);
        System.out.println(arr.size());
        arr.show();
        arr.delete(0);
        arr.show();
        arr.add(100);
        arr.add(101);
        arr.show();
        arr.insert(1,10);
        arr.show();
        arr.delete(1);
        arr.delete(2);
        arr.show();
        arr.delete(1);
        arr.insert(1,10);
        arr.show();
        arr.insert(0,100);
        arr.show();
        System.out.println("==================");
        System.out.println(arr.LinearSearch(5));

    }
}
