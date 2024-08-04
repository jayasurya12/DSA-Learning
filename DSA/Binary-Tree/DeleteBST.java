class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class DeleteBST {

    public TreeNode solve(TreeNode A, int B) {

        if (A == null) { // if A is null then return null
            return null;
        }
        if (B < A.val) { // if B is present on the left side
            A.left = solve(A.left, B);
        } else if (B > A.val) { // if B is present on the right side
            A.right = solve(A.right, B);
        } else {
            if (A.left == null && A.right == null) { // Case 1: No children, leaf node
                return null;
            } else if (A.left == null || A.right == null) { // Case 2: One child
                if (A.left == null) {
                    return A.right;
                } else {
                    return A.left;
                }
            } else { // Case 3: Two children
                TreeNode tempNode = A.left;
                // Iterate right part of left side of tree until we get the maximum node
                while (tempNode.right != null) {
                    tempNode = tempNode.right;
                }
                // Assign that maximum node value to A
                A.val = tempNode.val;
                // Now delete the node which was copied from its original position
                A.left = solve(A.left, tempNode.val);
            }
        }
        return A;
    }

    // Helper function to print the tree in-order (for testing purposes)
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        // Sample tree: 
        //     5
        //    / \
        //   3   7
        //  / \   \
        // 2   4   8

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        DeleteBST delete = new DeleteBST();
        System.out.println("Original tree (in-order):");
        delete.inOrder(root);
        System.out.println();

        // Deleting node with value 3
        root = delete.solve(root, 3);
        System.out.println("Tree after deleting 3 (in-order):");
        delete.inOrder(root);
        System.out.println();
    }
}
