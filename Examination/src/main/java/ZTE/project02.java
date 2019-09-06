package ZTE;

import java.util.*;

public class project02 {
    public static List<String> answerQueries(int numWords, String[] words, int numQuestings, int[] question){
        List<String> answerList = new ArrayList<>();
        Arrays.sort(words);//words就完成了从小到大排列
        for (int i = 0; i < question.length; i++) {
            if(question[i]==1){
               answerList.add(words[words.length-1]);
            }else if(question[i]==2){
                answerList.add(words[0]);
            }else if(question[i]==3){
                answerList.add(words[1]);
            }else if(question[i]==4){
                answerList.add(words[words.length-2]);
            }else{
                for (int i1 = 0; i1 < words.length; i1++) {
                    String word = words[i1];
                    word = new StringBuffer(word).reverse().toString();
                    words[i1] = word;
                }
                Arrays.sort(words);
                answerList.add(words[0]);

            }
        }
        return answerList;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"ah","cb","ef","gd"};
        int[] question = new int[]{1,2,3,4,5,1,2,3,4};
        List<String> strings = answerQueries(4, words, 9, question);
        System.out.println(strings);

    }
}
