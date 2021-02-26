import java.util.ArrayList;


public class oddPreEven {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            if(array[i]%2 == 0){
                even.add(array[i]);
            }else{
                odd.add(array[i]);
            }
        }
        int[] re = new int[array.length];
        for(int i=0; i<odd.size(); i++){
            re[i] = odd.get(i);
        }
        int tmp = odd.size();
        for(int i=0; i<even.size(); i++){
            re[tmp] = even.get(i);
            tmp++;
        }
        return re;
    }
}
