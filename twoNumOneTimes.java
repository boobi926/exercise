import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class twoNumOneTimes {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set set = new HashSet();
        for(int key:array){
            if(set.contains(key)){
                set.remove(key);
            }else{
                set.add(key);
            }
        }
       num1[0] = (int) set.toArray()[0];
        num2[0] = (int) set.toArray()[1];
    }
}
