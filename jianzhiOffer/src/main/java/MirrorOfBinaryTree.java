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
     * 二叉树的建树
     * @param array 输入数组
     */
    public void createBinTree(int[] array){

    }

    public static void main(String[] args) {
        int[] array = new int[]{8,6,10,5,7,9,11};


    }
}
