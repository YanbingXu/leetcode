/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class subtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //边界条件判定
        if(root1==null||root2==null){
            return result;
        }

        //先比较跟节点
        if(root1.val==root2.val){
            //然后判断其结构是否相等
            result = isSubtree(root1,root2);

        }
        //跟节点不相同，就从root1的左子树开始继续找是否存在与root2跟节点相等的节点
        if(!result){
            result = HasSubtree(root1.left,root2);

        }

        //找root1的右子树
        if(!result){
            result = HasSubtree(root1.right,root2);
        }

        return result;
    }

    /**
     *判断树的结构是否相等
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val !=root2.val){
            return false;
        }
        return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
    }
}