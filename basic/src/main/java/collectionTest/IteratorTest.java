package collectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
集合元素的遍历操作，使用迭代器Iterator接口
内部的方法，hasnext（）和next（）
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person("jerry",20));

        Iterator iterator = coll.iterator();
        //方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        //方式二
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
