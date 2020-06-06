package CommonUsedClass;

import org.junit.Test;

public class StringAfterClassTest {
    /*
    将一个字符串反转，将字符串中指定部分反转，比如abcdefg---afedcbg
    方式一：转换成char[]
     */
    public String reverseString(String str,int startIndex,int endIndex){
        if(str!=null){
            char[] charArray = str.toCharArray();
            for(int i=startIndex,j=endIndex;i<j;i++,j--){
                char temp=charArray[i];
                charArray[i]=charArray[j];
                charArray[j]=temp;
            }
            return new String(charArray);
        }
        return null;


    }

    //方式二：使用String的拼接操作
    public String reverseString2(String str,int startIndex,int endIndex){
        if(str != null){
            String reverseStr = str.substring(0,startIndex);
            for (int i = endIndex; i>=startIndex; i--) {
                reverseStr += str.charAt(i);

            }
            reverseStr+=str.substring(endIndex+1);
            return reverseStr;
        }
        return null;

    }

    //方式三：用stringbuilder或stringbuffer替代string拼接操作
    public String reverseString3(String str,int startIndex,int endIndex){
        if(str != null){
            StringBuilder sb = new StringBuilder(str.length());
            sb.append(str.substring(0,startIndex));
            for(int i=endIndex;i>=startIndex;i--){
                sb.append(str.charAt(i));
            }
            sb.append(str.substring(endIndex+1));

            return sb.toString();
        }
        return null;
    }



        @Test
    public void reverseTest(){
        String str = "abcdefg";
        String s1 = reverseString2(str, 2, 3);
        String s = reverseString3(str, 2, 3);
        System.out.println(s1);
        System.out.println(s);

    }

}
