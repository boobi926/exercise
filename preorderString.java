/*
给定一个二叉树，用前序遍历的方式将其转换为字符串数组，按要求加上括号
 */
public class preorderString {
    public Node buildTree(){
        Node A = new Node('1');
        Node B = new Node('3');
        Node C = new Node('2');
        Node D = new Node('5');
        Node E = new Node('9');
        Node F = new Node('4');
        Node G = new Node('6');
        Node H = new Node('7');
        A.left = B;
        A.riight = C;
        B.left = D;
        B.riight = E;
        E.riight = H;
        C.left = F;
        C.riight = G;
        return A;
    }
    public void preorderTostringchild(Node root,StringBuffer sb){
        //首先root为空，返回
        if(root==null)  return;
        sb.append(root.val); //将根节点先存入字符串
        if(root.left==null){
            if(root.riight==null){
                return;
            }else{
                sb.append("()");
            }
        }
        else{
            sb.append("(");
            preorderTostringchild(root.left,sb);
            sb.append(")");
        }

        if(root.riight==null){
            return;
        }
        else{
          sb.append("(");
          preorderTostringchild(root.riight,sb);
          sb.append(")");
        }
    }

    public String preorderTostring(Node root){
       StringBuffer sb = new StringBuffer();
       preorderTostringchild(root,sb);
       return sb.toString();
    }
    public static void main(String[] args){
        preorderString p = new preorderString();
        Node t = p.buildTree();

        System.out.println( p.preorderTostring(t));
    }
}
