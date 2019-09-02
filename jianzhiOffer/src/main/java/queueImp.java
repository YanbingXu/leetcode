import java.util.Stack;

public class queueImp {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    //push进一个栈，然后pop进另一个栈


    public void push(int node) {


        if (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);


    }
    //从第二个栈中pop
    public int pop() {
        while(!stack1.isEmpty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        int result = stack2.pop();
        return result;
    }
}