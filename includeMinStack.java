import java.util.Stack;

public class includeMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();

    public includeMinStack() {
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

}