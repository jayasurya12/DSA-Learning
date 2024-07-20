class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class Main {
    static boolean balanced = true;
    
    static int Height(TreeNode root) {
        if (root == null) return 0;

        int LH = Height(root.left);
        int RH = Height(root.right);

        if (Math.abs(LH - RH) > 1) {
            balanced = false;
        }

        return Math.max(LH, RH) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int height = Height(root);
        
        System.out.println("Height of the tree is: " + height);
        System.out.println("Is the tree balanced? " + balanced);
    }
}
