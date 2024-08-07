import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;  // Initialize left and right children as null.
    }
}

class Learn {
    // Method to insert elements into the binary tree in level order
    public static TreeNode insertLevelOrder(ArrayList<Integer> arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.size()) {
            if (arr.get(i) == -1) return null; // Skip -1 values

            TreeNode temp = new TreeNode(arr.get(i));
            root = temp;

            // Insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // Insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Method to print the binary tree in level order
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1));
        TreeNode root = null;
        root = insertLevelOrder(arr, root, 0);

        System.out.println("Level order traversal of the constructed binary tree:");
        printLevelOrder(root);
    }
}
