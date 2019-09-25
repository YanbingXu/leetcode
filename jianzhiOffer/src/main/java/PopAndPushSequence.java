import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 解决这个问题很直观的想法就是建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数字。
 *
 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，
 * 直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列就不可能是一个弹出序列。
 */
public class PopAndPushSequence {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean isPossible = true;
        //先进行边界的判定
        if (pushA.length==0 && popA.length ==0){
            isPossible = false;
        }

        //借助一个辅助栈来进行判断
        Stack<Integer> auxiliaryStack = new Stack();
        int index = 0;
        int i;

        for (i = 0; i < pushA.length; i++) {
            auxiliaryStack.push(pushA[i]);
            while(!auxiliaryStack.isEmpty() && auxiliaryStack.peek()==popA[index]){
                auxiliaryStack.pop();
                index++;
            }
        }

        if(i==pushA.length && index!=popA.length){
            isPossible = false;
        }
        return isPossible;
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        boolean b = IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
