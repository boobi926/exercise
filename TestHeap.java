import java.util.Arrays;

/*
向下调整，实现大根堆
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(){
        this.elem = new int[10];
    }
    //向下调整
    //root每棵子树的开始位置 len每颗字树的结束位置
    public void adjustDown(int root,int len){
        int parent = root;
        int child = parent*2+1; //2n+1表示左孩子下标
        while(child<=len){
            //0.判断是否有左右孩子，有的话找到最大值
            if(child+1<len && this.elem[child]<this.elem[child+1]){
                child++;
            }
            //代码指到这里，c表示最大值下标
            if(this.elem[child] > this.elem[parent]){
                 //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child; //往下走，检查下面子树
                child = parent*2+1;
            }else {
                break;
            }
        }

    }
    public void createHeap(int[] array) {
         for(int i = 0; i<array.length; i++){
             elem[i] = array[i];
             this.usedSize++;
         }
         //i是每颗树的根节点下标。this.usedSize-1表示完全二叉树的最后一个结点下标，（n-1）/2表示求父亲结点下标
        for(int i = (this.usedSize-1-1)/2; i>=0; i--){
            adjustDown(i,this.usedSize-1);
        }
    }
    public void show(){
        for(int i = 0; i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //插入
    public void push(int val){
        //0.首先判断堆是否满了,满了就要扩容
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        //1.放到数组的最后一个位置
        this.elem[this.usedSize]=val;
        this.usedSize++;
        //2.进行调整
        adjustUp(this.usedSize-1);
    }
    //调整为大根堆(向上调整)
    public void adjustUp(int child){
        int parent = (child-1)/2;

        while(child>0){
            if(this.elem[child]>this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                //parent = (child-1)/2;
                adjustUp(child);
            }else {
                break;
            }
        }
    }
    //判断堆是否满了
    public boolean isFull(){

        return this.usedSize == this.elem.length;
    }

    //删除（弹出栈顶元素）
    public void pop(){
        //0.是否为空
        if(isFull()){
            return;
        }
        //1.最后一个元素和堆定元素进行交换，
        int tmp = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = this.elem[0];
        this.elem[0] = tmp;
        this.usedSize--; //代表删除了最后的那个节点，也就是堆顶元素
        //2.调整0号下标和这棵树（向下调整）
        adjustDown(0,this.usedSize);
    }
    //堆排序（从小到大存储）
    public void heapSort(){
        int end  = this.usedSize-1;
        while(end>0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
    public static void main(String[] args){
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.push(80);
        testHeap.show();
        testHeap.pop();
        testHeap.show();
        System.out.println("排序：");
        testHeap.heapSort();
        testHeap.show();
    }
}
