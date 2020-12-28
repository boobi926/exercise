/*
二叉搜索树（每个结点的左节点都小于它，右节点都大于它）转换成排序的双向链表
 */
public class treeToDoublyList {
    public Node prev = null;
    //中序遍历改变二叉树的结构，变成双向链表
    public void fun(Node root){
        if(root == null){
            return ;
        }
        fun(root.left);
        root.left = prev;
        if(prev!=null){
            prev.riight = root;
        }
        prev = root;
        fun(root.riight);
    }
    //返回双向链表的头结点
    public Node solution(Node root) {
        if (root == null) {
            return null;
        }
        fun(root);
        Node head = root; //让head指向根节点
        while (head.left != null) {
            head = head.left;  //走到链表的头结点
        }
        return head;
    }

}
