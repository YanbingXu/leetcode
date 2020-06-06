package CommonUsedClass;

import org.junit.Test;

public class StringAfterClassTest3 {
    /*
    获取两个字符串中最大相同子串，比如：
    str1 = "abcwerthelloyuiodef"，str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较
     */

    public String getMaxSameString(String str1, String str2){
        String maxString = (str1.length()>=str2.length())?str1:str2;
        String minString = (str1.length()<str2.length())?str1:str2;

        //完善一下鲁棒性
        if(maxString!=null && minString!=null){

            int length = minString.length();

            for (int i = 0; i <=length ; i++) {
                for(int x=0,y=length-i;y<=length;x++,y++){
                    if(maxString.contains(minString.substring(x,y))){
                        return minString.substring(x,y);
                    }

                }


            }

        }
        return null;


    }

    @Test
    public void getMaxSameStringTest(){
        String str = "abcwerthelloyuiodabcdefgef";
        String str1 = "cvhellobabcdefgnm";

        String maxSameString = getMaxSameString(str, str1);
        System.out.println(maxSameString);

    }
}
