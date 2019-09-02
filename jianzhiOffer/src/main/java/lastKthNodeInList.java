public class lastKthNodeInList {
    public ListNode FindKthToTail(ListNode head,int k) {
        //用两个指针指向头结点，第一个指针先走k-1步，然后第二个指针开始走，当第一个指针到末尾时第二个指针指向倒数第k个
        ListNode a = head;
        ListNode b = head;
        if(head==null||k<=0){
            return null;
        }

        for(int i=1;i<k;i++){
            if(a.next!=null){

                a=a.next;
            }else{
                return null;
            }
        }
        while(a.next!=null){
            a=a.next;
            b=b.next;
        }

        return b;
    }
}
