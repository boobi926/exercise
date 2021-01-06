import java.util.Arrays;

public class sevenSort {
    //插入排序分为直接插入排序和希尔排序
    /*
    时间复杂度：
     （1）最坏情况是O（n^2）
      (2)最好情况是有序情况：O（n） 越有序越快
    空间复杂度：O（1）
    稳定性：稳定
     */
    public static void insertSort(int[] array){
        int tmp = 0;
        int j ;
        for(int i=1; i<array.length; i++){
             tmp = array[i];
            for( j=i-1; j>=0; j--){
                if(array[j] > tmp){
                    array[j+1] = array[j]; //调换位置
                }else{
                   // array[j+1] = tmp;   //不用换，放回原位
                    break;
                }
            }
            array[j+1] = tmp;   //不用换，放回原位
        }
    }

    //希尔排序 (直接插入排序时间复杂度太高，希尔排序采用分组的思想，对每组进行直接插入排序)
    //不稳定
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for(int i = 0; i<drr.length; i++){
            shell(array,drr[i]);
        }
    }
    public static void shell(int[] array,int gap){
       int tmp = 0;
       for(int i = gap; i<array.length; i++){
           tmp = array[i];
           int j;
           for(j=i-gap; j>=0; j-=gap){
               if(array[j]>tmp){
                   array[j+gap] = array[j];
               }else {
                   break;
               }
           }
           array[j+gap]=tmp;
       }

    }

    //选择排序
    /*
    时间复杂度：O（n^2）
    空间复杂度：O（1）
    稳定性：不稳定
     */
    public static void selectSort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[j]<array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

            }

    }

    //堆排序（首先要建立大跟堆）
    /*
      时间复杂度：O（nlogn）
    空间复杂度：O（1）
    稳定性：不稳定
     */
    public static void heapSort(int[] array){
        creatHeap(array);
        int end = array.length-1;
        while(end>0){
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    public static void creatHeap(int[] array){
        for(int i = (array.length-1-1)/2; i>=0; i--){
            adjustDown(array,i,array.length);
        }
    }
    public static void adjustDown(int[] array,int root,int len){
        int patrnt = root;
        int child = root*2+1;
        //最起码有左孩子
        while(child<len){
            //有右孩子且左孩子小于右孩子，进行交换
            if(child+1<len && array[child]<array[child+1]){
             int tmp = array[child];
             array[child] = array[child+1];
             array[child+1] = tmp;
            }
            //如果左孩子大于父亲结点，要进行交换
            if (array[child] > array[patrnt]) {
                int tmp = array[child];
                array[child] = array[patrnt];
                array[patrnt] = tmp;
                patrnt = child;
                child = patrnt*2+1;
            }else{
                break;
            }
        }
    }

    //冒泡排序
     /*
      时间复杂度：O（n^2）
    空间复杂度：O（1）
    稳定性：不稳定
     */
    public static void bubleSort(int[] array){
        //i表示趟数
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    //快速排序
    /*
      时间复杂度：nlogn     最坏情况：1 2 3 4 5 6 7 8 9 / 9 8 7 6 5 4 3 2 1  ：O（n^2）
    空间复杂度：lonn
    O（n）
    稳定性：不稳定
     */
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    public static void quick(int[] array,int left,int right){
        if(left>=right){
            return;
        }
       int par = partition(array,left,right);
        //递归排序左边和右边
        quick(array,left,par-1);
        quick(array,par+1,right);

    }
    public static int partition(int[] array,int left,int right){
        int tmp = array[left];
        while(left<right){

            while(left<right && array[right]>=tmp){
                right--;
            }
            array[left]=array[right];
            while(left<right && array[left]<=tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }

    //归并排序
    /*
    时间复杂度：nlogn
    空间复杂度：O(n)
    稳定性：稳定
     */
    public static void mergeSort(int[] array){

        mergeSortIn(array,0,array.length-1);
    }
    public static void mergeSortIn(int[] array,int low,int high){
        if(low>=high){
            return;
        }
        //分解（从数组中间一分为二，直至分解为一个一个的数）
        int mid = (low+high)>>>1; //右移相当于除2
        mergeSortIn(array,low,mid);
        mergeSortIn(array,mid+1,high);
        //归并（将一个一个的数按序归并）
        merge(array,low,mid,high);
    }
    public static void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1; //新数组的长度
        int[] ret = new int[len]; //新建一个数组用来存放归并排序后的数
        int i = 0; //表示ret数组的下标

        while (s1<=mid && s2<=high){
            if(array[s1] <= array[s2]){
                ret[i++] = array[s1++];
            }else {
                ret[i++] = array[s2++];
            }
        }
        while (s1<=mid){
            ret[i++] = array[s1++];
        }
        while (s2<=high){
            ret[i++] = array[s2++];
        }
        for(int j= 0; j<ret.length; j++){
            array[j+low] = ret[j];
        }
    }

    //归并排序的非递归实现
    /*
    时间复杂度：nlogn
    空间复杂度：O(n)
    稳定性：稳定
     */
    public static void MergeSort(int[] array){
        for (int gap = 1; gap < array.length; gap *= 2) {
            mergeNor(array,gap);
        }
    }
    public static void mergeNor(int[] array,int gap){
        int[] ret = new int[array.length];
        int k = 0; // 表示新数组的下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2  = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1;

        //1.肯定是有两个归并段的
        while (s2 < array.length) {
            //2.对应的s1位置和s2位置进行比较
            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                }else {
                    ret[k++] = array[s2++];
                }
            }
            //3.上述第二步在比较的过程中，肯定会有一个下标先走完一个归并段
            //4.判断是谁没走完，把剩下的数据拷贝到结果数组中
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }

            //5,。接着确定新的s1,e1,s2,e2
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < array.length ? s2+gap-1 :  array.length-1;
        }

        //6.还需要判断是否已另外的归并段
        while (s1 <= array.length-1) {
            ret[k++] = array[s1++];
        }

        for (int i = 0; i < ret.length; i++) {
            array[i] = ret[i];
        }
    }
    public static void main(String[] args){
        int[] array = {10,5,8,4,1,9};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("快速排序：");
        quickSort(array);
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("归并排序(递归)：");
        System.out.println(Arrays.toString(array));
        MergeSort(array);
        System.out.println("归并排序(非递归)：");
        System.out.println(Arrays.toString(array));
    }
}
