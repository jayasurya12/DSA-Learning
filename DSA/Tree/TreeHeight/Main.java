import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class TreeHeightCalculator {
    int Height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> elementQueue = new LinkedList<>();
        elementQueue.add(root);
        int numberofNodeLevels = 0;

        while (true) {
            int currentLevelSize = elementQueue.size();
            if (currentLevelSize == 0) {
                return numberofNodeLevels;
            }

            while (currentLevelSize > 0) {
                TreeNode currentNode = elementQueue.poll();

                if (currentNode.left != null) {
                    elementQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    elementQueue.add(currentNode.right);
                }

                currentLevelSize--;
            }

            numberofNodeLevels++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a sample tree: 
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeHeightCalculator treeHeight = new TreeHeightCalculator();
        int height = treeHeight.Height(root);

        System.out.println("Height of the tree is: " + height);
    }
}
