public class DemoBST {
    public static void main (String[] args) {
        BST bst = new BST(50);

        bst.insert(bst.root, 20);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 100);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 80);
        bst.inOrder(bst.root);
        bst.delete(bst.root, 60);
        // int[] inOrderArray = bst.inOrder(bst.root);
        // System.out.print(inOrderArray);
        if (bst.search(bst.root, 70) == null) {
            System.out.println("Not found");
        } else {
            System.out.println("found");
        }
        int size = bst.size(bst.root);
        System.out.println(size + " : total length");
          
        // sum of nodes.
        int sum = bst.sum(bst.root);
        System.out.println(sum + " : Sum of the Nodes");

        // height of node;
        int height = bst.height(bst.root);
        System.out.print(height + " : Height of Node");
        
        // left subtree
        bst.leftsum(bst.root);
    }
}