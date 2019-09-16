package project03.com.atguigu.team.view;

import java.util.Scanner;

/**
 * 项目提供了TSUtility.java类，可用来方便的实现键盘访问
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 该方法读取键盘，如果用户键入1-4，则方法返回，返回值为用户键入字符对应的方法
     *
     * @return
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新输入：");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * 该方法提示并等待，直到用户按回车键后返回
     */
    public static void readReturn() {
        System.out.println("按回车键继续...");
        readKeyBoard(100, true);
    }

    /**
     * 该方法从键盘读取一个长度不超过2的整数，并将其作为方法的返回值
     *
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取Y或者N并将其作为方法的返回值
     *
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，重新输入：");
            }


        }
        return c;
    }

    /**
     * 封装一个私有的readkeyboard方法用于读取键盘输入的值
     *
     * @param limit
     * @param blankReturn
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不大于" + limit + ")错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }


}
