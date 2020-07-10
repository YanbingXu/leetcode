package collectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 * 1。集合、数组都是对多个数据进行存储操作的结构，简称java容器
 * 说明：此时的存储主要指的是内存层面的存储，不涉及到持久化的存储
 *
 * 2。数组在存储多个数据方面的特点
 *      >一旦初始化，长度就确定
 *      >数组一旦定义好，元素类型就确定了，只能操作指定类型的数据String[] arr,   int[]arr1
 *
 * 3。数组在存储多个数据方面的缺点
 *      1）一旦初始化后，其长度就不可修改
 *      2）数组中提供的方法有限，对于删除，插入等操作非常不便，效率不高
 *      3）获取数组中实际元素的个数，没有现成方法可用
 *      4）数组存储数据的特点：有序、可重复。对于无序、不能重复的需求，数组不可满足
 *
 * 二、集合框架
 *      > collection接口：单列集合，用来存一个一个的对象
 *          list接口：存储 有序、可重复的数据     "动态"数组
 *              arraylist linkedlist vector
 *          set接口：存储 无序的、不可重复的数据
 *              Hashset LinkedHashSet TreeSet
 *
 *      > map接口：双列集合，用来存储一对（key-value）数据
 *              HashMap LinkedHashMap TreeMap HashTable Properties
 *
 *
 * 三、collection接口中的方法
 *
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add():将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size()
        System.out.println(coll.size());//4

        //addAll():将新集合的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(3465);
        coll1.add("TTY");
        coll.addAll(coll1);
        System.out.println(coll.size());//6


        //clear():清空当前集合内的所有元素
        coll.clear();

        //isEmpyt：是否为空
        System.out.println(coll.isEmpty());


    }
}
