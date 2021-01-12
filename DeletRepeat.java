import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
        去除十万个数据中重复的数字
         */
public class DeletRepeat {
    public static void main(String[] args){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<10_0000; i++){
            list.add(random.nextInt(5000));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer val:list){
            hashSet.add(val);
        }
        System.out.println(hashSet);

    }

}
