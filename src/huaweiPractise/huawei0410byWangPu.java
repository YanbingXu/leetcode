package huaweiPractise;
import java.util.*;
public class huawei0410byWangPu {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            String[] strr = new String[100];
            int n = scan.nextInt();

            for(int i=0;i<n;i++){
                strr[i]=scan.next();

            }
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder(strr[i]);
                if(strr[i].length()%8!=0){
                    for(int j=0;j<8-(strr[i].length()%8);j++){
                        sb.append("0");
                    }
                    while(sb.length()>=8){
                        System.out.printf(sb.substring(0, 8)+" ");

                        sb=sb.delete(0, 8);
                    }
                }else{
                    while(sb.length()>=8){
                        System.out.println(sb.substring(0, 8)+"0");
                        sb=sb.delete(0, 8);
                    }
                    System.out.println("00000000");
                }
            }
        }
    }
}


