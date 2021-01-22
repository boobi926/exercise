/*
写一个泛型类，包含一个方法，该方法是找到数组当中的最大值
T extends Comparable<T> 泛型的上界
 */
class Generic<T extends Comparable<T>>{
    public  T findMax(T[] array){
        T max = array[0];
        for(int i = 0; i<array.length; i++){
            if(array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;

    }
}

public class maxArray {
    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] array = {1,4,23,56,34,8,10};

        System.out.println(generic.findMax(array));
    }
}