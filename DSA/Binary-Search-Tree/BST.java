class Node {
    int key;
    Node left, right;

    public Node (int key) {

        this.key = key;
        left = right = null;

    }
}

public class BST{

    Node root;

    public Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);
    
        if (val < root.key)
            root.left = insert(root.left, val);
        else if (val > root.key) 
            root.right = insert(root.right, val);
    
        return root;
    }
    

    public Node search(Node root, int val) {

        if (root == null || root.key == val)
            return root;

        if (val < root.key)
            return search(root.left, val);
    
        return search(root.right, val);
    }

    public BST(int val) {
        root = new Node(val);
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }
    
    public int size(Node root) {
        if (root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }
    
    public int sum(Node root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.key;
    }

    public int height(Node root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}