package collectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
collection接口中声明方法的测试

结论：
向collection接口实现类的对象中添加数据obj时，要求obj所在类要重写equals
 */
public class CollectionMetodTest {
    @Test
    public void test(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person("jerry",20));

        //contains（obj）：判断当前集合是否包含呢obj
        //在调用是会调用obj所在类的equals方法
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("tom")));//true，重写过，比的是内容
        System.out.println(coll.contains(new Person("jerry",20)));//false,因为没有重写equals方法

        //containsAll（collection coll1）判断形参coll1中的所有元素是否存在与coll中。
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person("jerry",20));

        //remove()
        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("jerry",20));//person类记得从写toString方法
        System.out.println(coll);

        //removeAll（）：从当前集合中移除coll1中的全部元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person("jerry",20));


        //retrainAll():交集
        Collection coll1 = Arrays.asList(123,456);

        coll.retainAll(coll1);

        System.out.println(coll);//[123, 456, 456]

        //equals(Objection obj):当前集合与形参（集合）是否相同
        Collection coll2 = Arrays.asList(123,456);
        System.out.println(coll.equals(coll2));

    }


    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person("jerry",20));

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合---->数组：toArray
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组-->集合：调用arrays类的静态方法asList
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "cc", "DD"});
        System.out.println(strings);

        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);//[[I@593634ad],认为是作为整体的一个元素

        List<Integer> integers1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers1);//要new包装类[123, 456]




        List<Integer> integers = Arrays.asList(123, 456);
        System.out.println(integers);//[123, 456]



    }
}
