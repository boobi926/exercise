import java.util.Stack;

//用栈实现队列
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        //入队全部入到第一个栈中
        stack1.push(x);
    }

    //出队
    public int pop(){
        /*
        1.判断Stack2中是否有元素
        2.如果没有，判断是
         */
        int data = 0;
        if(empty()){
            return -1;
        }
        if(stack2.isEmpty()){
            //导入第一个栈的元素
           while(!stack1.isEmpty()){
               stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peak(){
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty(){
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }

}
