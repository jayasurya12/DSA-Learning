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
}