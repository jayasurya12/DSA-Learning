public class Demo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.insertLeft(tree.root, 5);
        tree.insertRight(tree.root, 15);

        tree.insertLeft(tree.root.left, 3);
        tree.insertRight(tree.root.left, 8);
        tree.insertLeft(tree.root.right, 12);
    }
}