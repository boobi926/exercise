 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null)  return true;
        return childSymmetrical(pRoot.left,pRoot.right);
    }
    boolean childSymmetrical(TreeNode p,TreeNode q){
        if(p==null && q==null)  return true;
        if(p==null || q==null)  return false;
        if(p.val != q.val)  return false;
        return childSymmetrical(p.left,q.right) && childSymmetrical(p.right,q.left);
    }
}
