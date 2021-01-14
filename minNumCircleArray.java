import java.util.ArrayList;
public class minNumCircleArray {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        int mid ;

        if(array.length==0){
            return 0;
        }
        while(left < right){
            if(array[left] < array[right])  return array[left];
            mid = (right-left) / 2;
            if(array[right] > array[mid]){
                right = mid;
            }else if(array[mid] > array[left]){
                left = mid+1;
            }else{
                left++;
            }
        }
        return array[left];
    }
}