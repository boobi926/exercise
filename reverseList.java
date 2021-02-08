import java.util.*;

public class reverseList {

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if(head==null || head.next==null) return head;
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while(cur!=null){
                stack.add(cur);
                cur = cur.next;
            }
            head.next = null;
            ListNode nhead = stack.pop();
            ListNode node = nhead;
            while(!stack.isEmpty()){
                node.next = stack.pop();
                node = node.next;
            }
            return nhead;
        }
    }
}
