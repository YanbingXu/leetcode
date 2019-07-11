package dataStructure;

public class testHanota {
    public static void main(String[] args) {
        hanota(2,'a','b','c');

    }

    public static void hanota(int i,char from,char in ,char to){
        if(i==1){
            System.out.println("第1个盘子从"+from+"到"+to);
        }else{
            hanota(i-1,from,to,in);
            System.out.println("第"+i+"个盘子从"+from+"到"+to);
            hanota(i-1,in,from,to);
        }

    }
}
