import java.util.*;
public class midTimesArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int mid = array.length/2;
        for(Integer key:array){
            if(hashMap.get(key) == null){
                hashMap.put(key,1);
            }else{
                Integer val = hashMap.get(key);
                hashMap.put(key,val+1);
            }
            Integer tim = hashMap.get(key);
            if(tim>mid)  return key;
        }
        return 0;
    }
}
