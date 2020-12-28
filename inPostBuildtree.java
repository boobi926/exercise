/*
给出后序遍历的数组和中序遍历的数组，构建二叉树
 */
public class inPostBuildtree {

    public Node buildTreeChild(int[] inorder,int[] postorder,int inbegin,int inend){
        int postIndex = postorder.length-1; //根节点在后序遍历中在最后的位置
        if(inbegin>inend) return null;  //没有结点
        Node root = new Node((char) postorder[postIndex]);
        //找到当前根节点在中序遍历中的位置下标
        int rootIndex = findIndexofInorder(inorder,inbegin,inend,postorder[postIndex]);
        postIndex--;
        if(rootIndex==-1){
            return null;
        }
        //递归求出根节点左树和右树
        root.riight = buildTreeChild(inorder,postorder,rootIndex+1,inend); //先构建右树，因为后续遍历是左-》右-》根，根节点左边先是右树结点
        root.left = buildTreeChild(inorder,postorder,inbegin,rootIndex-1); //中序遍历中根节点左边都是左子树，右边都是右子树、

        return  root;
    }
    //找到根节点在中序遍历数组中下标位置
    public int findIndexofInorder(int[] inorder,int inbegin,int inend,int val ){
        for(int i = inbegin; i<=inend; i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    //构建二叉树
    public  Node buildTree(int[] inorder,int[] postorder){
        if(inorder==null || postorder==null){
            return null;
        }
        if(inorder.length<=0 || postorder.length<=0){
            return null;
        }
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
}
