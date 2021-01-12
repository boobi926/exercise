import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
找出数组中只出现一次的数字
 */
public class oneceNum {
    public static int singleNumber(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<array.length; i++) {
            if (hashSet.contains(array[i])) {
                hashSet.remove(array[i]);
            } else {
                hashSet.add(array[i]);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }
    public static void main(String[] args){

        int[] array = {2,6,2,6,9,5,8,9,5};

        System.out.println(oneceNum.singleNumber(array));
    }
}
