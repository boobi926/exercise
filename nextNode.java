import java.util.*;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class nextNode {
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode cur = pNode;
        while(cur.next!=null){
            cur=cur.next;
        }
        addNode(cur);
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==pNode){
                return i==list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    public void addNode(TreeLinkNode root){
        if(root==null) return;
        addNode(root.left);
        list.add(root);
        addNode(root.right);
    }
}
