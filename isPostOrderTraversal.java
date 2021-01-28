//给定一个数组，判断是不是某二叉搜索树的后序遍历

public class isPostOrderTraversal {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        return func(sequence,0,sequence.length-1);
    }
    public boolean func(int[] sequence,int start,int root){
        if(start>=root) return true;
        int value = sequence[root];
        int i;
        for(i=start; i<root;i++){
            if(sequence[i] > value)
                break;
        }
        for(int j=i; j<root; j++){
            if(sequence[j] < value) return false;
        }
        return func(sequence,start,i-1) && func(sequence,i,root-1);
    }
    public  void main(String[] args){
        int[] array = {4,8,6,12,16,14,10};
        System.out.print(VerifySquenceOfBST(array));
    }
}
