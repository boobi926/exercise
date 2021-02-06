import java.util.*;
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class commonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead2==null || pHead1==null) return null;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        HashMap<ListNode,Integer> map = new HashMap<>();
        while(cur1!=null){
            map.put(cur1,cur1.val);
            cur1=cur1.next;
        }
        while(cur2!=null){
            if(map.containsKey(cur2)){
                return cur2;
            }
            cur2=cur2.next;
        }
        return null;
    }
}
