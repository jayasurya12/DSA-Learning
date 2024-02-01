public class BinaryTree {
    Node root;
    class Node {
        int data;
        Node left,right;
        public Node (int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public BinaryTree (int data) {
        root = new Node(data);
    }
}