package arrayDemo1Homework;

/**
 * 二分查找的事例
 * 前提：数组是有序的
 */
public class binarySearchArr {
    public static void main(String[] args) {
        int[] arr = new int[]{-94,-35,0,2,5,17,88};

        int dest = 33;

        boolean isFlag = true;
        int head = 0;
        int end = arr.length-1;
        while(head<=end){
            int middle = (head+end)/2;
            if(dest == arr[middle]){
                System.out.println("已找到目标,索引是："+ middle);
                isFlag = false;
                break;
            }else if(arr[middle]<dest){
                head = middle+1;
            }else{
                end = middle-1;

            }

        }

        if(isFlag){
            System.out.println("目标不存在");

        }

    }
}
