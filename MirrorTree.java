public class MirrorTree {
    public void Mirror(TreeNode root) {
        if(root == null) return ;
        if(root.left==null && root.right==null)  return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
