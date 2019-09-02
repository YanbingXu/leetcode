package project01;

import java.util.Scanner;

/**
 * util工具类：
 * 将不同功能封装为方法，可以直接通过调用方法使用其功能，无需考虑具体的实现细节
 */
public class util {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 用于界面菜单的选择， 该方法读取键盘，如果用户输入1-4的数，方法返回，返回值为用户键入字符
     */
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'){
                System.out.println("选择错误，重新输入");
            }else{
                break;
            }

        }
        return c;
    }
    /**
     * 用于收入和支出金额的输入，该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值
     */
    public static int readNum(){
        int n;
        for(;;){
            String str = readKeyBoard(4);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入有误请重新输入：");
            }

        }
        return n;
    }
    /**
     * 用于收入和支出的说明
     */
    public static String readString(){
        String str=readKeyBoard(8);
        return str;
    }
    /**
     * 用于确认选择的输入。该方法从键盘读取Y或者N，将其作为方法的返回值
     */
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else{
                System.out.println("选择有误，重新输入");
            }
        }
        return c;

    }

    private static String readKeyBoard(int limit) {
        String line = "";

        while (scanner.hasNext()){
            line=scanner.nextLine();
            if(line.length()<1||line.length()>limit){
                System.out.println("输入长度（不大于"+limit+")错误，请重新输入：");
                continue;
            }
           break;

        }
        return line;
    }


}
