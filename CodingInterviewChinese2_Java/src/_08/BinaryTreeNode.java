package _08;

public class BinaryTreeNode {
    int val;                // 值
    BinaryTreeNode left;    // 左子树
    BinaryTreeNode right;   // 右子树
    BinaryTreeNode parent;  // 父亲节点
    
    BinaryTreeNode(int val) {
        this.val = val;
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
            root.left.parent = root;
        }
        if(leftLength < endPreorder - startPreorder) {
            // 构建右子树
            root.right = constructCore(preorder, leftPreorder+1, endPreorder,
                                    inorder, rootInorder+1, endInorder);
            root.right.parent = root;
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
