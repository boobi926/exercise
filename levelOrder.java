import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class levelOrder {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > Rlist = new ArrayList<>();
        if(pRoot==null)   return Rlist;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(pRoot);
        int start = 0, end = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            list.add(cur.val);
            start++;
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
            if(start == end){
                end = queue.size();
                start = 0;
                Rlist.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return Rlist;
    }
}
