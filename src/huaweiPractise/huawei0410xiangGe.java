package huaweiPractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class huawei0410xiangGe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] split = inputString.split("\\ ");
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            String tempString = split[i];
            if(tempString.length()>100){
                return;
            }
            int length = tempString.length() / 8;
            if (length < 1) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < tempString.length(); j++) {
                    stringBuffer.append(tempString.charAt(j));
                }
                while (stringBuffer.length() < 8) {
                    stringBuffer.append(0);
                }
                strings.add(stringBuffer.toString());
            } else {

                for (int j = 0; j < length; j++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int k = j * 8; k < (j + 1) * 8; k++) {
                        stringBuffer.append(tempString.charAt(k));
                    }
                    while (stringBuffer.length() < 8) {
                        stringBuffer.append(0);
                    }
                    strings.add(stringBuffer.toString());
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = length * 8; j < tempString.length(); j++) {
                    stringBuffer.append(tempString.charAt(j));
                }
                while (stringBuffer.length() < 8) {
                    stringBuffer.append(0);
                }
                strings.add(stringBuffer.toString());
            }
        }
        Collections.sort(strings);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.size() - 1; i++) {
            stringBuffer.append(strings.get(i));
            stringBuffer.append(" ");
        }
        stringBuffer.append(strings.get(strings.size() - 1));
        System.out.println(stringBuffer.toString());
    }
}


