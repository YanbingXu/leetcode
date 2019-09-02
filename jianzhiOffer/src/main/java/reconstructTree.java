/**
 * Definition for binary tree
 public class TreeNode {
    int val;
   TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
 }
 */
public class reconstructTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reconstructCore( pre, 0, pre.length - 1,in, 0, in.length - 1);
    }

    public TreeNode reconstructCore(int[] pre, int preleft, int preright, int[] in, int inleft, int inright) {
        if(preleft>preright||inleft>inright){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preleft]);
        //对中序数组进行遍历
        for(int i=inleft;i<=inright;i++){
            if(in[i]==pre[preleft]){
                treeNode.left = reconstructCore(pre,preleft+1,preleft+i-inleft,in,inleft,i-1);
                treeNode.right = reconstructCore(pre,preleft+i+1-inleft,preright,in,i+1,inright);
            }
        }
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}