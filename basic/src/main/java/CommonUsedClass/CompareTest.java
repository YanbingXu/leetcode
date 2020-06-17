package CommonUsedClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 二：comparable接口的使用与comparator的使用对比：
 * comparable接口方式一旦定义，保证comparable接口实现类的对象在任何位置都可以比较大小
 comparator接口属于临时性的比较
 */
public class CompareTest {
    /*
    Comparable接口的使用
    1.像String、包装类等实现了Comparable接口，重写了compareTo（）方法，给出了比较两个对象的方法
    进行了从小到大的排序
    2.重写comparableTo（obj）的规则：
    如果当前对象this大于形参对象obj，返回正整数
    如果当前对象this小于形参对象obj，返回负整数
    如果当前对象this等于形参对象obj，返回0

    自定义类如果需要排序，可以让自定义类实现comparable接口，重写compareTo方法，（自然排序）

     */
    @Test
    public void test(){
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test2(){
        GoodDefined[] arr = new GoodDefined[5];
        arr[0] = new GoodDefined("lianxiangMouse",34);
        arr[1] = new GoodDefined("xiaomiMouse",12);
        arr[2] = new GoodDefined("huaweiMouse",20);
        arr[3] = new GoodDefined("pingguoMouse",100);
        arr[4] = new GoodDefined("DellMouse",20);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    comparator接口的使用：定制排序
    1。背景：
    当元素的类型没有实现comparable接口，又不方便修改代码
    或者实现了java.lang.comparable接口，但排序规则不适合当前的操作，
    那么可以考虑使用comparator接口
    2。规则：
    重写compare（object o1，object o2）方法，比较两个对象的大小
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};

        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test4(){
        GoodDefined[] arr = new GoodDefined[5];
        arr[0] = new GoodDefined("lianxiangMouse",34);
        arr[1] = new GoodDefined("xiaomiMouse",12);
        arr[2] = new GoodDefined("huaweiMouse",20);
        arr[3] = new GoodDefined("pingguoMouse",100);
        arr[4] = new GoodDefined("DellMouse",20);

        Arrays.sort(arr, new Comparator<GoodDefined>() {
            //指明商品按照产品名称从低到高，然后价格从高到低
            @Override
            public int compare(GoodDefined o1, GoodDefined o2) {
                if(o1 instanceof GoodDefined && o2 instanceof GoodDefined){
                    GoodDefined g1 = (GoodDefined)o1;
                    GoodDefined g2 = (GoodDefined)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());

                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}
