import java.util.Stack;

public class Gupiao {
    class StockSpanner {
        private Stack<Integer> stack;
        private Stack<Integer> stack2;  //跨度的栈
        public StockSpanner() {
          stack = new Stack<>();
          stack2 = new Stack<>();
        }

        public int next(int price) {
            int n = 1;//跨度初始化为1
            //
            while (!stack.isEmpty() && stack.peek() <= price) {
                stack.pop();
                n += stack2.pop();
            }

           stack.push(price);
            stack2.push(n);
            return n;

        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
