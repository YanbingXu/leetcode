import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *      8
      /  \
     6   10
    / \  / \
   5  7 9 11
 镜像二叉树
       8
     /  \
    10   6
    / \  / \
   11 9 7  5

 *
 */
public class MirrorOfBinaryTree {
    private static LinkedList<TreeNode> nodeList;

    /**
     * 二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode left = root.left;
            root.left= root.right;
            root.right = left;
            Mirror(root.left);
            Mirror(root.right);

        }


    }

    /**
     * 二叉树的建树.
     * 二叉树跟数组的关系是层次遍历的关系
     * @param array 输入数组
     */
    public  void createBinTree(int[] array) {
        nodeList = new LinkedList<TreeNode>();
        for (int i = 0; i < array.length; i++)
            nodeList.add(new TreeNode(array[i]));
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);

    }

    /**
     * 前序遍历（递归方法）
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    /**
     * 层次遍历输出，和建树方法相同
     * @param root
     */
    public static void levelOrder(TreeNode root){
        //用队列数据结构来进行遍历，先进先出，遍历时先跟再左再右
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
           queue.add(root);
           while(!queue.isEmpty()){

               TreeNode temp = queue.poll();
               System.out.print(temp.val+"\t");
               if(temp.left!=null){
                   queue.add(temp.left);
               }
               if(temp.right!=null){
                   queue.add(temp.right);
               }
           }
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{8,6,10,5,7,9,11};
        new MirrorOfBinaryTree().createBinTree(array);
        levelOrder(nodeList.get(0));
        System.out.println();
        System.out.println("***********");
        preOrder(nodeList.get(0));
        System.out.println();
        new MirrorOfBinaryTree().Mirror(nodeList.get(0));
        levelOrder(nodeList.get(0));
        System.out.println();
        System.out.println("**************");
        preOrder(nodeList.get(0));




    }
}
