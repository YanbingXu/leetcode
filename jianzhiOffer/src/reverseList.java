/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.Stack;

public class reverseList {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while(head!=null){

            stack.push(head);
            head = head.next;
        }

        while(!stack.isEmpty()){
            temp.next= stack.pop();
            temp = temp.next;
        }
        temp.next=null;


        return result.next;
    }
}