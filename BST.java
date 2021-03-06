public class BST {
    // inorder = left > root > right
    // to print BST from the smallest
    public static void inorder(Node root) {
        if (root == null) {
            return ;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node insert(Node root, int key) {
        // if root is null, return a new node and return it
        if (root == null) {
            return new Node(key);
        }
        // if key is less than the root,
        // recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // if key is bigger or equal to the root,
        // recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void search(Node root, int target) {
        // if the target is not in the BST)
        if (root == null) {
            System.out.print("\nThe target " + target + " is not found.");
            return ;
        }
        // if the target is less than the root,
        // search the left subtree
        if (target < root.data) {
            search(root.left, target);
        }
        // if the target is bigger than the root,
        // search the right subtree
        else if (target > root.data) {
            search(root.right, target);
        }
        // if the target is found
        else {
            System.out.print("\nThe target " + target + " is found.");
        }
    }

    /*public static Node delete(Node root, int target) {
        // if target is not found
        if (root == null) {
            return null;
        }
        // if target is smaller than the root,
        // recur for the left subtree
        if (target < root.data) {
            root.left = delete(root.left, target);
        }
        // if target is bigger than the root,
        // recur for the right subtree
        else if (target > root.data) {
            root.right = delete(root.right, target);
        }
        // if target is found
        else {
            // Case 1: if the node has no children
            if (root.left == null && root.right == null) {
                return null; // deleted
            }
            else if (root.left != null && root.right != null) {

            }
        }
    }*/
    
    public static Node buildBST(int[] keys) {
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
        return root;
    }

    public static void main(String args[]) {
        int[] keys = {6, 5, 7, 2, 3, 8, 4, 1, 9};
        //          6
        //      5       7
        //    2           8
        //  1   3           9
        //        4
        Node root = buildBST(keys);
        inorder(root);

        search(root, 4);
        search(root, 9);
        search(root, 10);
        preorder(root);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}