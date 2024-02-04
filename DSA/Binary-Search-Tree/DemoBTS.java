public class DemoBTS {
    public static void main (String[] args) {
        BST bst = new BST(50);

        bst.insert(bst.root, 20);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 80);

        bst.inOrder(bst.root);
    
        if (bst.search(bst.root, 70) == null)
            System.out.print("Not found");
        else
            System.out.print("found");

    }
}