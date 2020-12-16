

//设计一个循环队列
public class MyCircularQueue {

    public int[] elem;
    public int front;
    public int rear;



    public MyCircularQueue(int k) {
        this.elem= new int[k];
    }

    //入队
    public boolean enQueue(int value){
        //先判断它是否为空
        if(isFull()){
            return false;
        }else{
            this.elem[this.rear]=value;
            this.rear=(this.rear+1)%this.elem.length;
            return true;
        }

    }
    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front=(this.front+1)%this.elem.length;  //让front往后走一个
        return true;
    }
    //得到队头元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }
    //得到队尾元素
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index = this.rear==0?this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

    public boolean isEmpty(){
        return this.rear==this.front;
    }

    public boolean isFull(){
        if((this.rear+1)%this.elem.length==this.front){
            return true;
        }
        return false;
    }


}

