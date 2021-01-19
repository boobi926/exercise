public class Times1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for(int i = 1; i<= n; i *= 10){
            int k = n%(i * 10);
            int m = 0;
            if(k>(2*i-1)) m = i;
            else if(k<i)  m=0;
            else m=k-i+1;
            count += (n/(i*10))*i + m;
        }
        return count;
    }
}