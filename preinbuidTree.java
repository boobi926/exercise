public class preinbuidTree {
    public int preindex = 0;  //根节点在前序遍历中位于0号下标位置
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null) return null;
        if(pre.length<=0 || in.length<=0) return null;
        return buidTree( pre ,in,0,in.length-1);
    }
    public TreeNode buidTree(int[] pre,int[] in,int inbegin,int inend){
        if(inbegin>inend) return null;  //代表数组中没有结点
        TreeNode root = new TreeNode(pre[preindex]);
        int rootindex = index(in,inbegin,inend,pre[preindex]);
        preindex++;
        if(rootindex==-1)  return null;
        //递归求出根节点左树和右树
        root.left = buidTree(pre,in,inbegin,rootindex-1);
        root.right = buidTree(pre,in,rootindex+1,inend);
        return root;
    }
    //找到根节点在中序遍历中的位置下标
    public int index(int[] in,int inbegin,int inend,int val ){
        for(int i=0;i<=inend; i++){
            if(in[i] == val){
                return i;
            }
        }
        return -1;
    }
}
