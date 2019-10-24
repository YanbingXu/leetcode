package jiaotongBank;
/**
 * 设计一种排序方式，按照元素的频率降序对正整数列表进行排序，频率高的元素排在低的元素前面
 * 相同的元素，其排列顺序同他们在给定列表中出现的顺序相同
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class FrequencySort {
    public static List<Integer> frequencySort(int arr[], int size){
        //result集合保存最终结果
        List<Integer> result = new ArrayList<Integer>();
        //map集合统计数组数字频率
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i =0;i<arr.length;i++) {
            if(h.get(arr[i]) == null) {
                h.put(arr[i], 1);
            }else {
                h.put(arr[i], h.get(arr[i])+1);
            }
        }
        Set<Entry<Integer,Integer>> keySet = h.entrySet();
        List<Entry<Integer, Integer>> infoIds = new ArrayList<>(keySet);
        //按list集合按值大小降序排序
        Collections.sort(infoIds,new Comparator<Entry<Integer, Integer>>(){
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        //得到最终结果
        for(int i = 0;i<infoIds.size();i++) {
            for(int j = 0;j<infoIds.get(i).getValue();j++) {
                Integer id = infoIds.get(i).getKey();
                result.add(id);
            }
        }
        return result;

    }

    public static void main(String[] args) {
//        int[] arr =new int[]{1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10};
        int[] arr =new int[]{1,2,4,4,3,5};
        int size = 6;
        List<Integer> results = frequencySort(arr, size);
        System.out.println(results);

    }
}
