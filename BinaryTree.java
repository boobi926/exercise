import java.util.*;

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
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.riight);
    }
    //中序遍历  左-》根-》右
    void inOrderTraversal(Node root){
        if(root == null){
           return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.riight);

    }
    //后序遍历  左-》右-》根
    void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.riight);
        System.out.print(root.val+" ");
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
    //子问题求解树的高度（左树高度和右树高度取最大值加一）
      int getHeight(Node root){
          if(root == null){
              return 0;
          }
          int leftHeight = getHeight(root.left);
          int rightHeight = getHeight(root.riight);
          return leftHeight>rightHeight?leftHeight+1:rightHeight
          +1;

       }
       //查找val所在结点，没有就返回null；
      //按照根-》左-》右 顺序查找
      //一旦找到，立即返回，不要继续在其他位置查找
      Node find(Node root,char val){
        if(root == null){
            return null;
        }
        //1.判断根节点是否是要找的数字
        if(root.val==val){
            return root;
        }
        //2.左边递归完，返回值是否为空
        Node left = find(root.left,val);
        if(left!=null){
            return left;
        }
        //3.右边递归
        Node right = find(root.riight,val);
        if(right!=null){
            return right;
        }
        return null;
      }

      //求第K层的结点个数
    int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }else {
            return getKLevelSize(root.left,k-1)+getKLevelSize(root.riight,k-1);
        }
    }
      //判断这棵树是否是镜像对称树
      public boolean isSymmetric(Node root) {
          if(root == null){
              return true;
          }
          return childSymmetric(root.left,root.riight);

      }
    public boolean childSymmetric(Node p,Node q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return childSymmetric(p.left,q.riight) && childSymmetric(p.riight,q.left);
    }
     //判断是否是平衡树（每个结点的左子树与右子树的高度差的绝对值不大于1）
    public boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int lHeight = Height(root.left);
        int rHeight = Height(root.riight);
        return Math.abs(lHeight-rHeight)<=1 && isBalanced(root.left) && isBalanced(root.riight);

    }
     int Height(Node root){
        if(root == null){
            return 0;
        }
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.riight);

        return lHeight>rHeight?lHeight+1:rHeight+1;

    }
    //层序遍历
    public List<Character> levelOrder(Node root) {
        List<Character> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
         while(cur!=null || !stack.isEmpty()){
             while(cur!=null){
                 stack.push(cur);
                 list.add(cur.val);
                 cur = cur.left;
             }
             Node top = stack.pop();
             cur = top.riight;
         }
         return list;
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
        Node ret = binaryTree.find(root,'H');
        System.out.println("该值的结点是："+ret.val);
        System.out.println("第三层结点的个数是："+binaryTree.getKLevelSize(root,3));
        System.out.println("该树是否呈镜像对称："+binaryTree.isSymmetric(root));
        System.out.println("该树是否是平衡二叉树："+binaryTree.isBalanced(root));
        System.out.println("层序遍历："+binaryTree.levelOrder(root));
    }


}
