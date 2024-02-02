class Node {
    int data;
    Node left,  right;
    public Node (int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class BinaryTree {
    Node root;
    public BinaryTree (int data) {
        root = new Node(data);
    }
    public void insertLeft(Node r, int val) {
        if (r != null) {
            r.left = new Node(val);
        } else {
            System.out.println("Parent node is null, cannot insert left child.");
        }
    }
    public void insertRight(Node r, int val) {
        if (r != null) {
            r.right = new Node(val);
        } else {
            System.out.println("Parent node is null, cannot insert left child.");
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}