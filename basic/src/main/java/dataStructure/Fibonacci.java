package dataStructure;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));

    }

    public static int Fibonacci(int index){
        //1,1,2,3,5,8,13,21...
        if(index ==1 || index == 2){
            return 1;
        }
        return Fibonacci(index-1)+Fibonacci(index-2);

    }
}

