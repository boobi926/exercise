import java.util.ArrayList;
public class multiplyArray {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i=0; i<A.length; i++){
            int flg = A[i];
            A[i] = 1;
            B[i] = 1;
            for(int j=0; j<A.length; j++){
                B[i] *= A[j];
            }
            A[i] = flg;
        }
        return B;
    }
    public void main(String[] args){
        int[] A = {1,2,3,4,5};
        System.out.println(multiply(A).toString());
    }
}