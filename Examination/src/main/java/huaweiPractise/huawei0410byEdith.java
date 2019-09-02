package huaweiPractise;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

public class huawei0410byEdith {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> stringsFinal = new ArrayList<>();
        while (in.hasNext()){
            String[] split = in.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            for(int i=1;i<=n;i++){
                operate(split[i], stringsFinal);
            }
            sort(stringsFinal);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < stringsFinal.size() - 1; i++) {
                stringBuffer.append(stringsFinal.get(i));
                stringBuffer.append(" ");
            }
            stringBuffer.append(stringsFinal.get(stringsFinal.size() - 1));
            System.out.println(stringBuffer.toString());

        }
    }

    public static ArrayList operate(String s,ArrayList<String> strings) {

        if(s==" "){
            return strings;
        }
        if(s.length()>8){
            strings.add(s.substring(0,8));
            s=s.substring(8);
            operate(s,strings);

        }else{
            StringBuffer sb = new StringBuffer();
            sb.append(s);
            for(int k=0;k<8-s.length();k++){
                sb.append('0');
            }
            strings.add(sb.toString());
        }
        return strings;
    }
}
