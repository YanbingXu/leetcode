package xinlang;//import java.util.Arrays;
//
//public class project01 {
//    public  static  String getModule (String[]list){
//        String tempResult;
//        if(list.length==1){
//            return list[0];
//        }else if(list.length<1){
//            return null;
//        }else{
//            tempResult = compareVersion(list[0],list[1]);
//            for (int i = 2; i < list.length; i++) {
//                tempResult = compareVersion(tempResult, list[i]);
//                }
//            }
//
//        return tempResult;
//    }
//
//
//    public static String compareVersion(String version1, String version2) {
//
//        String[] versionArray1 = version1.split("\\.");
//        String[] versionArray2 = version2.split("\\.");
//
//
//        int len1 = versionArray1.length;
//        int len2 = versionArray2.length;
//        int len = len1 <= len2 ? len1 : len2;
//
//        //共有版本号部分，从前向后比较对应位置数字
//        int x1, x2;
//        for (int i = 0; i < len; i++) {
//            x1 = Integer.parseInt(versionArray1[i]);
//            x2 = Integer.parseInt(versionArray2[i]);
//            if (x1 < x2) {
//                return version1;
//            }
//        }
//
//        //共有版本号相等的情况下，谁的版本号段数更多且多余部分不全为0，谁的版本更新
//
//        if (len1 < len2) {
//            for (int i = len; i < len2; i++) {
//                if (Integer.parseInt(versionArray2[i]) > 0) {
//                    return version2;
//                }
//            }
//        }
//
//        return version2;
//    }
//
//    public static void main(String[] args) {
//        String[] string  = new String[]{"3","4.3.5.4","2.10.3","2.4"};
//
//        System.out.println(getModule(string));
//    }
//}
