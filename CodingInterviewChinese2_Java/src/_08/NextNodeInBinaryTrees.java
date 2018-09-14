package _08;

/**
 * 面试题8：二叉树的下一个节点
 *
 */
public class NextNodeInBinaryTrees {

    public static void main(String[] args) {
        
        // 普通二叉树
        int[] pre1 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in1 = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println("普通二叉树：" + getNext(BinaryTreeNode.construct(pre1, in1)).val);

        // 只有左子树
        int[] pre2 = {1, 2, 3, 4};
        int[] in2 = {4, 3, 2, 1};
        System.out.println("只有左子树：" + getNext(BinaryTreeNode.construct(pre2, in2)));
        
        // 只有右子树
        int[] pre3 = {1, 2, 3, 4};
        int[] in3 = {1, 2, 3, 4};
        System.out.println("只有右子树：" + getNext(BinaryTreeNode.construct(pre3, in3)).val);
        
        // 只有一个根结点
        System.out.println("只有一个根结点：" + getNext(new BinaryTreeNode(1)));
        
    }

    public static BinaryTreeNode getNext(BinaryTreeNode btn) {
        if(btn == null) {
            return null;
        }
        
        // btn 有右子树
        if(btn.right != null) {
            BinaryTreeNode next = btn.right;
            while(next.left != null) {
                next = next.left;
            }
            return next;
        }
        
        // btn 有父亲节点
        if(btn.parent != null) {
            BinaryTreeNode next = btn.parent;
            
            // 当前节点为父节点的左子树（其实可以不写，直接让最后 return next，写上是为了省下面的 while 循环）
            if(btn == btn.parent.left) {
                return next;
            }
            
            // 当前节点为父节点的右子树
            while(next.parent != null && next == next.parent.right) {
                next = next.parent;
            }
            
            // 包括 next.parent 为 null 的情况（当 btn 是中序遍历最后一个结点时）
            return next.parent;
        }
        
        // btn 是没有右子树的根结点
        return null;
    }
    
}
