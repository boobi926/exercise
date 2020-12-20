
class Node{
    public char val;
    public Node left;   //左孩子
    public Node riight;   //右孩子

    public Node(char val){
        this.val = val;
    }
}
public class BinaryTree {


    public Node buildTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.riight = C;
        B.left = D;
        B.riight = E;
        E.riight = H;
        C.left = F;
        C.riight = G;
        return A;
    }
    //前序遍历（递归实现） 根-》左-》右
    void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.riight);
    }
    //中序遍历  左-》根-》右
    void inOrderTraversal(Node root){
        if(root == null){
           return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val+" ");
        inOrderTraversal(root.riight);

    }
    //后序遍历  左-》右-》根
    void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.riight);
        System.out.println(root.val+" ");
    }
    //遍历思路求结点个数
    static int size = 0;
    void getSize1(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.riight);

    }
    //子问题思路————结点的个数（左树的结点+右树的结点+本身）

    int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.riight)+1;
    }
    //求叶子结点的个数
    static int leafSize = 0;
    int getLeafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.riight==null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.riight);
        return leafSize;
    }
    //子问题求叶子结点的个数

    int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.riight==null){
            return 1;
        }

        return getLeafSize2(root.left)+getLeafSize2(root.riight);
    }
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println("结点的个数："+BinaryTree.size);
        binaryTree.getSize2(root);
        System.out.println("结点的个数："+BinaryTree.size);

        System.out.println("叶子结点个数："+ binaryTree.getLeafSize(root));
        System.out.println("叶子结点个数："+ binaryTree.getLeafSize2(root));
    }
}
