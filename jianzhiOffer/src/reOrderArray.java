import java.util.ArrayList;
import java.util.Arrays;
public class reOrderArray {
    public void reOrderArray(int [] array) {
        //两次遍历先把奇数插入list然后把偶数插入list
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                arrayList.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                arrayList.add(array[i]);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            array[i]=(int)arrayList.get(i);
        }
        System.out.println(Arrays.toString(array));

    }


}

