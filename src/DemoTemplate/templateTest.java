package DemoTemplate;

public class templateTest {
    public static void main(String[] args) {
        template t  =new subTemplate();
        t.spendTime();

    }
}

abstract class template{
    public void spendTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("程序运行的时间是："+(end-start));
        
    }

    public abstract void code() ;
}

class subTemplate extends template{

    @Override
    public void code() {
        //写一个查找一千以内的质数
        for(int i=2;i<1000;i++){
            boolean isFlag = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }

        }
    }
}