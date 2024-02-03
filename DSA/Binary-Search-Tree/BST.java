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
        if (root == null) {
            return new Node(val);
        }
        if (val < root.key) {
            root.left = insert(root.left, val);
        } if (val > root.key) {
            root.right = insert(root.right, val);
        }
    }

    public void insert() {

    }

    public BST(int val) {
        root = new Node(val);
    }
    public BST() {
        root = null;
    }
}
// unable to access 'https://github.com/user-name/repo/': Could not resolve host: github.com