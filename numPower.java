import java.util.Scanner;

public class numPower {
    public double Power(double base, int exponent) {
        double res = 1.0;
        if(base==0 && exponent<=0){
            throw new RuntimeException();
        }
        for(int i=0; i<Math.abs(exponent); i++){
            res *= base;
        }
        return exponent>0 ? res:1/res;
    }
    public static void main(String[] args){
        numPower np = new numPower();
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        int exponent = sc.nextInt();
        System.out.println(np.Power(base,exponent));
    }
}
