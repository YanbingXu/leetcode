package CommonUsedClass;

import org.junit.Test;

import java.util.Arrays;

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

    /*
    对上面的题目进行扩展，如果有多个相同子串，应该怎么做？
    1。返回类型为String[],先不用arraylist，用stringbuffer转换为String[]
     */
    public String[] getMaxSameStrings(String str1, String str2){
        String maxString = (str1.length()>=str2.length())?str1:str2;
        String minString = (str1.length()<str2.length())?str1:str2;

        //完善一下鲁棒性
        if(maxString!=null && minString!=null){

            int length = minString.length();
            //用一个sb来暂时接受string数组
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <=length ; i++) {
                for(int x=0,y=length-i;y<=length;x++,y++){
                    if(maxString.contains(minString.substring(x,y))){
                        sb.append(minString.substring(x,y)+",");
                    }

                }

//                System.out.println(sb);
                //这里要手动break出来，找到了最大子串，下面的就不找了
                if(sb.length()>0){
                    break;
                }
            }
            //debug看的化不用replaceAll好像也可以，split会默认出去最后一个逗号后的空串，但是这里还是加上保证逻辑完整
            String[] split = sb.toString().replaceAll(",$", "").split("\\,");
            return split;

        }
        return null;


    }


    @Test
    public void getMaxSameStringTest(){
        String str = "abcwerthello1yuiodabcdefef";
        String str1 = "cvhello1babcdefnm";

        String maxSameString = getMaxSameString(str, str1);
        System.out.println(maxSameString);

        System.out.println("**********************");
        String[] maxSameStrings = getMaxSameStrings(str, str1);
        System.out.println(Arrays.toString(maxSameStrings));


    }
}
