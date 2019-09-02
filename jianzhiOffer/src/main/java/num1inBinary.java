public class num1inBinary {
    public int NumberOf1(int n) {
        int result=0;
        String s = Integer.toBinaryString(n);
        //System.out.println(s.toString());
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                //System.out.println("i:"+i);
                result+=1;
            }
        }

        return result;
    }
}