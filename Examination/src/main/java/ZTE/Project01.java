package ZTE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project01 {
    public static int countPerfectDancer(int countMorning,int countEvening, int[] morningList,int[] eveningList){
        //1.在早课列表中而不在晚课列表的人，countMoring++
        int onMorning = 0;
        List<Integer> list1 = new ArrayList<>();
        for (int j = 0; j < morningList.length; j++) {
            list1.add(morningList[j]);
        }
        for (int i = 0; i < eveningList.length; i++) {
            if (!list1.contains(eveningList[i])) {
                onMorning++;
            }
        }


        //2.在晚课列表而不在早课列表的人，countEvening++
        int onEvening = 0;
        List<Integer> list3 = new ArrayList<>();
        for (int j1 = 0; j1 < eveningList.length; j1++) {
            list3.add(eveningList[j1]);
        }
        for (int i1 = 0; i1 < morningList.length; i1++) {
            if (!list3.contains(morningList[i1])) {
                onMorning++;
            }
        }
        //3。返回countMoring+countEvening
        return onMorning+onEvening;
    }

    public static void main(String[] args) {
        int[] morningList = new int[]{1, 2, 3, 4};
        int[] eveningList = new int[]{2, 3, 5, 6, 7};

        int i = countPerfectDancer(4, 5,morningList , eveningList);
        System.out.println(i);

    }
}
