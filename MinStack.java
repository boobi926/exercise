import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //最小栈没有元素
        if (minstack.isEmpty()) {
            minstack.push(x);

        } else {
            //最小站有元素，拿到栈顶元素和x比较
            int top = minstack.peek();
            if (x <= top) {
                minstack.push(x);
            }
        }
    }

    public void pop() {
        if (!stack.empty()) {
            int tmp = stack.pop();
            if (minstack.peek() == tmp) {
                minstack.pop();
            }
        }
    }
    public int min() {
        if (!minstack.isEmpty()) {
            return minstack.peek();
        }
        return -1;
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }


    public static void main(String[] args){
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(-2);
        myStack.push(3);
        myStack.push(-4);
        System.out.println(myStack.top());

    }
}
