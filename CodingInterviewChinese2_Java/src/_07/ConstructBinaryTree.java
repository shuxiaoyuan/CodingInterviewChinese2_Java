package _07;


/**
 * 面试题7：重建二叉树
 * P62
 */
public class ConstructBinaryTree {
    
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        System.out.print("先序遍历：");
        DLR(root);
        System.out.print("\n中序遍历：");
        LDR(root);
        System.out.println();
    }
    
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) {
            throw new RuntimeException("输入的先序/中序遍历序列不正确！");
        }
        
        return constructCore(preorder, 0, preorder.length-1,
                        inorder, 0, inorder.length-1);
    }
    
    public static BinaryTreeNode constructCore(int[] preorder, int startPreorder, int endPreorder,
                                int[] inorder, int startInorder, int endInorder) {
        
        // 先序遍历序列中第一个值为根结点的值
        int rootValue = preorder[startPreorder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        
        if(startPreorder == endPreorder) {
            if(startInorder == endInorder) {
                return root;
            }
            else {
                throw new RuntimeException("输入的先序/中序遍历序列不正确！");
            }
        }
        
        // 在中序遍历序列中找到根结点的值
        int rootInorder = startInorder;
        while(rootInorder <= endInorder && inorder[rootInorder] != rootValue) {
            rootInorder++;
        }
        // 感觉原书这里的判定有问题
        if(rootInorder > endInorder) {
            throw new RuntimeException("输入的先序/中序遍历序列不正确！");
        }
        
        int leftLength = rootInorder - startInorder;
        int leftPreorder = startPreorder + leftLength;
        
        if(leftLength > 0) {
            // 构建左子树
            root.left = constructCore(preorder, startPreorder+1, leftPreorder,
                                    inorder, startInorder, rootInorder-1);
        }
        if(leftLength < endPreorder - startPreorder) {
            // 构建右子树
            root.right = constructCore(preorder, leftPreorder+1, endPreorder,
                                    inorder, rootInorder+1, endInorder);
        }
        
        return root;
        
    }
    
    public static void DLR(BinaryTreeNode btn) {
        if(btn != null) {
            System.out.print(btn.val + " ");
            DLR(btn.left);
            DLR(btn.right);
        }
    }
    
    public static void LDR(BinaryTreeNode btn) {
        if(btn != null) {
            LDR(btn.left);
            System.out.print(btn.val + " ");
            LDR(btn.right);
        }
    }
    
}
