package CommonUsedClass;

import org.junit.Test;

public class StringAfterClassTest2 {
    /*
    获取一个字符串在另一个字符串中遇到的次数
    比如：获取ab在abkkcadkabkebfkabkskab中出现的次数
     */

    public int getCount(String mainStr,String subStr){

        if(mainStr.length()>=subStr.length()){
            int count=0;
            int index;
            while((index = mainStr.indexOf(subStr)) != -1){
                count++;
                mainStr = mainStr.substring(index+subStr.length());

            }
            return count;

        }else{
            return 0;
        }

    }


    public int getCount2(String mainStr,String subStr){
        if(mainStr.length()>=subStr.length()){
            int count = 0;
            int index = 0;
            while((index=mainStr.indexOf(subStr,index)) != -1){
                count++;
                index+=subStr.length();
            }
            return count;
        }else{
            return 0;
        }
    }


        @Test
    public void test(){
        String str = "abkkcadkabkebfkabkskab";
        String str1 = "ab";
        int count = getCount2(str, str1);
        System.out.println(count);


    }
}
