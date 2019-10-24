import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTreeFromTop2Bottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode temp = root;
        while(temp!=null){
            arrayList.add(root.val);
            temp = temp.left;

        }

        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ArrayList<Integer> arrayList = PrintFromTopToBottom(root);
        System.out.println(arrayList);


    }
}
