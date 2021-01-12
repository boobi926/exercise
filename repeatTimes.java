import java.util.*;

/*
统计十万个数据中重复数据出现的次数
 */
public class repeatTimes {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(5000));
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(Integer key:list){
            if(hashMap.get(key) == null){
                hashMap.put(key,1);
            }else{
                Integer val = hashMap.get(key);
                hashMap.put(key,val+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次！");
        }
    }
}
