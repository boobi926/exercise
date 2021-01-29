import java.util.*;
public class kSmallInTree {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null) return null;
        inoder(pRoot);
        if(list.size()>=k && k>=1){
            return list.get(k-1);
        }
        return null;
    }
    void inoder(TreeNode root){
        if(root==null) return;
        inoder(root.left);
        list.add(root);
        inoder(root.right);
    }

}
