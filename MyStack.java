//用队列实现栈

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        /*1.那个队列不为空，就将元素放到哪个队列中
        2.如果两个队列都为空，就放到第一个
         */
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    //出栈
    public int pop() {
     /*1.判断栈是否为空
     2.出不为空的那个队列
     3.n个元素的话，出n-1个元素到另一个队列去（保存到另外队列）
     */
        int data = 0;
        int size1 = queue1.size();
        int size2 = queue2.size();
        if (empty()) {
            return -1;
        } else if (queue1.isEmpty()) {
            for (int n = 0; n < size2 - 1; n++) {
                queue1.offer(queue2.poll());
            }
            data = queue2.poll();
        } else {
            for (int n = 0; n < size2 - 1; n++) {
                queue2.offer(queue1.poll());
            }
            data = queue1.poll();
        }
        return data;
    }
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }

    public int top(){
        int n = 0;
        int size1 = queue1.size();
        int size2 = queue2.size();
        if (empty()) {
            return -1;
        }
        if (queue1.isEmpty()) {
            for (int i = 0; i < size2 - 1; i++) {
               n = queue2.poll();
               queue1.offer(n);
            }

        } else {
            for (int i = 0; i < size2 - 1; i++) {
                n = queue1.poll();
                queue2.offer(n);
            }

        }
        return n;
    }
}
