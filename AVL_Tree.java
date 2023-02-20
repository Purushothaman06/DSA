public class AVL_Tree {
    TreeNode root;

    class TreeNode {
        int key;
        int height;
        TreeNode left, right;

        /**
         * @param val
         * 
         */
        TreeNode(int val) {
            key = val;
            height = 0;
            left = right = null;
        }
    }

    /**
     * @param val
     * 
     */
    public AVL_Tree(int val) {
        root = new TreeNode(val);
    }

    public AVL_Tree() {
        root = null;
    }

    /**
     * @param node
     * @return height of the given node.
     * 
     */
    public int getHeight(TreeNode node) {
        if(node == null)
            return -1;
        return node.height;
    }

    /**
     * @param a
     * @param b
     * @return maximum element form the given nodes
     * 
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * @param val
     * 
     */
    public void insert(int val) {
        insert(root, val);
    }

    /**
     * @param node
     * @param val
     * @return inserted node
     * 
     */
    private TreeNode insert(TreeNode node, int val) {
        if(node == null) 
            return new TreeNode(val);

        if(val < node.key) 
            node.left = insert(node.left, val);
        else if(val > node.key)
            node.right = insert(node.right, val);
        else 
            return node;

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));
         
        int balFactor = getBalFactor(node);

        // LL case
        if(balFactor > 1 && val < node.left.key) {
            return rightRotate(node);
        }

        // LR case
        if(balFactor > 1 && val > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR case
        if(balFactor < -1 && val < node.right.key) {
            return leftRotate(node);
        }

        // RL case
        if(balFactor < -1 && val > node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * @param z
     * @return root node after the rotation
     * 
     */
    private TreeNode leftRotate(TreeNode z) {
        TreeNode y = z.right;
        TreeNode t3 = y.left;

        y.left = z;
        z.right = t3;

        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    /**
     * @param z
     * @return root node after the rotation
     * 
     */
    private TreeNode rightRotate(TreeNode z) {
        TreeNode y = z.left;
        TreeNode t3 = y.right;

        y.right = z;
        z.left = t3;

        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    /**
     * @param node
     * @return balance factor of the given node
     * 
     */
    private int getBalFactor(TreeNode node) {
        if(node == null) 
            return 0;
        return getBalFactor(node.left) - getBalFactor(node.right);
    }

    /**
     * @param root
     * 
     */
    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.key+ " ");
            inOrder(root.right);
        }
    }
}
