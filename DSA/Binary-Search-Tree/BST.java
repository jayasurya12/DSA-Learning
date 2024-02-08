import java.util.ArrayList;
import java.util.Stack;



public class BST{

    Node root;
    class Node {
        int key;
        Node left, right;
    
        public Node (int key) {
    
            this.key = key;
            left = right = null;
    
        }
    }
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

        // Stack<Node> stk = new Stack<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        // Node curr = root;

        // while (curr != null || !stk.isEmpty()) {
        //     if (curr != null) {
        //         stk.push(curr);
        //         curr = curr.left;
        //     } else {
        //         arr.add(stk.peek().key);  // Assuming 'key' is the value of the node
        //         curr = stk.pop().right;
        //     }
        // }

        // int[] result = new int[arr.size()];
        // for (int i = 0; i < arr.size(); i++) {
        //     result[i] = arr.get(i);
        // }
        // return result;
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
        if (root == null) return -1;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public Node delete(Node root, int val) {

        if (root == null) return root;
    
        if (val < root.key) {
            root.left = delete(root.left, val);
        } else if (val > root.key) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = min(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    public int min(Node root) {
        int minVal = root.key;
        while(root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }
    // print of left subtree
    public void leftsum(Node root) {
        if (root == null) {
            System.out.println(0);
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){ //finding here leaf node
            sum += root.left.key;
        } else {
            leftsum(root.left);
        }
        leftsum(root.right);
        System.out.print(sum);
    }
}