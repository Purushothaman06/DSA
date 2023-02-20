/**
 * Binary Search Tree Implementation using Java
 * Insert - O(h)
 * Search - O(h)
 * Delete - O(h)
 * h - height of the Binary search tree
 * 
 * If the Tree is Balanced, then the time complexity 
 * Insert - O(log n)
 * Search - O(log n)
 * Delete - O(log n)
 * 
 */
public class BinarySearchTree {
    TreeNode root;

    class TreeNode {
        int key;
        TreeNode left, right;

        /**
         * @param val
         * 
         */
        TreeNode(int val) {
            key = val;
            left = right = null;
        }
    } 

    /**
     * @param val
     * 
     */
    BinarySearchTree(int val) {
        root = new TreeNode(val);
    }

    BinarySearchTree() {
        root = null;
    }

    /**
     * @param val
     * 
     */
    public void insert(int val) {
        insert(root, val);
    }

    /**
     * @param root
     * @param val
     * @return inserted Node
     * 
     */
    public TreeNode insert(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        if(val < root.key)
            root.left = insert(root.left,val);
        else  
            root.right = insert(root.right,val);

        return root;
    }

    /**
     * @param val
     * 
     */
    public void delete(int val) {
        root = delete(root, val);
    }

    /**
     * @param root
     * @param val
     * @return deleted Node 
     * 
     */
    public TreeNode delete(TreeNode root, int val) {    
        if(root == null)            
            return root;

        if(val < root.key)
            root.left = delete(root.left,val);
        else if(val > root.key)
            root.right = delete(root.right,val);
        else {
            if(root.left == null)
                return root.right; 
            else if(root.right == null)  
                return root.left;

            // for two child node
            root.key = min(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    /**
     * @param root
     * @return minimum value
     * 
     */
    private int min(TreeNode root) {
        int minVal = root.key;
        while(root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

    /**
     * @param root
     * @param val
     * @return searched Node
     * 
     */
    public TreeNode search(TreeNode root, int val) {
        if(root == null || root.key == val)
            return root;

        if(val < root.key)
            return search(root.left,val);
        
        return search(root.right,val);
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