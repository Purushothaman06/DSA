public class BinaryTree<T> {
    TreeNode root;
    
    class TreeNode {
        T data;
        TreeNode left, right;
        
        /**
         * @param val
         * 
         */
        TreeNode(T val) {
            data = val;
            left = right = null;
        }
    }

    /**
     * @param val
     * 
     */
    BinaryTree(T val) {
        root = new TreeNode(val);
    }

    BinaryTree() {
        root = null;
    }

    /**
     * @param node
     * @param val
     * 
     */
    public void addLeft(TreeNode node, T val) {
        TreeNode newNode = new TreeNode(val);
        node.left = newNode;
    }

    /**
     * @param node
     * @param val
     * 
     */
    public void addRight(TreeNode node, T val) {
        TreeNode newNode = new TreeNode(val);
        node.right = newNode;
    }

    /**
     * @param root
     * 
     */
    public static void preOrder(BinaryTree<Integer>.TreeNode root) {
       if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
       }
    }

    /**
     * @param root
     * 
     */
    public static void inOrder(BinaryTree<Integer>.TreeNode root) {
        if(root != null) {
            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }
    }

    /**
     * @param root
     * 
     */
    public static void postOrder(BinaryTree<Integer>.TreeNode root) {
        if(root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
