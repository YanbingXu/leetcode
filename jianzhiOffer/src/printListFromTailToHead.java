import java.util.Stack;
import java.util.ArrayList;
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //先把node值放入一个堆栈中，然后依次pop进arraylist中即可实现从尾到头
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
