package xinlang;

/**
 * 功能说明：LeetCode 165 - Compare Version Numbers
 * 开发人员：Tsybius2014
 * 开发时间：2015年9月18日
 */
public class simpleImpl {

    /**
     * 比较版本号
     * @param version1 版本号1
     * @param version2 版本号2
     * @return
     * 中文：比较两个版本version1和version2，
     * 如果version1晚于version2，则返回1，
     * 如果version1早于version2，则返回-1，其他情况下返回0
     */
    public static String compareVersion(String version1, String version2) {

        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");


        int len1 = versionArray1.length;
        int len2 = versionArray2.length;
        int len = len1 <= len2 ? len1 : len2;

        //共有版本号部分，从前向后比较对应位置数字
        int x1, x2;
        for (int i = 0; i < len; i++) {
            x1 = Integer.parseInt(versionArray1[i]);
            x2 = Integer.parseInt(versionArray2[i]);
            if (x1 < x2) {
                return version1;
            }
        }

        //共有版本号相等的情况下，谁的版本号段数更多且多余部分不全为0，谁的版本更新

        if (len1 < len2) {
            for (int i = len; i < len2; i++) {
                if (Integer.parseInt(versionArray2[i]) > 0) {
                    return version2;
                }
            }
        }

        return version2;
    }

    public static void main(String[] args) {
        String s = compareVersion("2.2.1", "2.2");
        System.out.println(s);
    }
}
