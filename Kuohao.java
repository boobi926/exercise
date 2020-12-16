import java.util.Stack;

public class Kuohao {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //new一个栈

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果是左括号就放入栈中
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            //遇到右括号先判断栈是否为空，为空说明右括号多
            else {
                if (stack.empty()) {
                    System.out.println("右括号多！");
                    return false;
                }
                //再看栈顶元素是否和当前右括号匹配，匹配就出栈，
                char ch2 = stack.peek();
                if (ch2 == '(' && ch == ')' || ch2 == '[' && ch == ']' || ch2 == '{' && ch == '}') {
                    stack.pop(); //匹配上就出栈
                } else {
                    System.out.println("左右括号不匹配！");
                    return false;
                }

            }
        }
        if(!stack.empty()){
            System.out.println("左括号多！");
            return false;
        }

        return true;
    }
}
