import java.util.*;
public class entranceNode {

    public ListNode EntryNodeOfLoop(ListNode pHead){
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while(cur!=null){
            set.add(cur);
            cur = cur.next;
            if(set.contains(cur)){
                return cur;
            }
        }
        return null;
    }
}
