import java.util.*;
public class removeRepeatNode {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null) return null;
        if( pHead.next==null) return pHead;
        HashSet<ListNode> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pre.next;
        while(cur!=null){
            if(pre==cur){
                set.add(cur);
            }
            pre = pre.next;
            cur = cur.next;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        pre = head;
        cur = pHead;
        while(cur!=null){
            if(set.contains(cur)){
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = pre.next;
                cur = cur.next;
            }

        }
        return head.next;
    }
}
