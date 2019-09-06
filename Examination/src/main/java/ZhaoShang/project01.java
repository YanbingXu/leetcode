package ZhaoShang;

import java.util.Scanner;

public class project01 {
    public static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(new StringBuffer(),n);
        System.out.println(project01.res);
    }

    public static void fun(StringBuffer sb,int n){
        if(n==0){
            res++;
            return;
        }
        for(int i=0;i<3;i++){
            char c = (char)('A'+i);
            sb.append(c);
            if((!sb.toString().contains("BBB")&&(!sb.toString().contains("CC")))){
                fun(sb,n-1);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
