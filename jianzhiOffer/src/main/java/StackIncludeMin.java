import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：空间换时间
 */
public class StackIncludeMin {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        if(min.isEmpty() || node<=min.peek() ){
            min.push(node);
        }else{
            min.push(min.peek());
        }
        data.push(node);
    }

    public void pop() {
        //增加边界条件判断
        if(!data.isEmpty() && !min.isEmpty()){
            data.pop();
            min.pop();
        }

    }

    public int top() {
        //增加边界条件
        if(!data.isEmpty()){

            return data.peek();
        }

        return 0;
    }

    public int min() {
        //增加边界条件
        if(!min.isEmpty()){
            return  min.peek();
        }

        return 0;
    }

    public static void main(String[] args) {
        StackIncludeMin s = new StackIncludeMin();
        s.push(3);
        int min = s.min();
        System.out.println(min);
        s.push(4);
        int min2 = s.min();
        System.out.println(min2);

    }
}
