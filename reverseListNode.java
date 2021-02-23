import java.util.*;
public class reverseListNode {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}