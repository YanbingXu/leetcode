package jiaotongBank;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：八幢房屋组成的部落。以单元表示，排列成直线，每天每个单元都与他相邻的单元（邻居）竞争。
 * 整数值1表示一个活跃单元，数值0表示一个非活跃单元。如果相邻单元都活跃或者都不活跃，那么该单元第二天的状态为不活跃；否则为活跃、
 * 部落两端的单元都只有一个邻居单元，我们假设另一个邻近单元一直处于不活跃状态。
 * 即使更新单元状态后，要考虑之前的状态以更新其他单元状态。应更新所有单元的单元信息。

 编写一个算法，求出给定天数后所有单元的状态。
 */
public class unitsActivaton {
    public static List<Integer> cellCompete(int[] states,int days){
        //result集合保存最终结果
        List<Integer> result = new ArrayList<Integer>();
        if(days<=0){
            for (int i = 0; i < states.length; i++) {
                result.add(states[i]);
            }
            return result;
        }

        int[] tempArr = new int[]{0,0,0,0,0,0,0,0};//存储中间变量的数组
        for(int j =0;j<days;++j){
            for(int i =0;i<8;i++){
                if(i==0){
                    tempArr[i]=0^states[1];
                }else if(i==7){
                    tempArr[i] = states[6]^0;
                }else{
                    tempArr[i] = states[i-1]^states[i+1];
                }
            }

            for (int i = 0; i < 8; ++i)//某一天的情況處理完以後，將中間數組中的值賦予原數組
            {
                states[i] = tempArr[i];
            }
        }



        for (int i = 0; i < tempArr.length; i++) {
            result.add(tempArr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] states = new int[]{0,1,0,1,0,1,0,1};
        List<Integer> integers = cellCompete(states, 4);
        System.out.println(integers);

    }
}
