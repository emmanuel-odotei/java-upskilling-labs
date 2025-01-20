package intermediate.src.week1_labs.advance_ds;



public class AVLTree {
    public static class AVLNode {
        int data;
        AVLNode left;
        AVLNode right;
        int height;
        
        public AVLNode(int data) {
            this.data = data;
            this.height = 1; // New node is initially added at leaf
        }
    }
    
    private AVLNode root;
    
    // Get the height of the node
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }
    
    // Get the balance factor of a node
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    // Right rotate subtree rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode temp = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = temp;
        
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x; // New root
    }
    
    // Left rotate subtree rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode temp = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = temp;
        
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y; // New root
    }
    
    // Insert a node
    public AVLNode insert(AVLNode node, int key) {
        // Perform the normal BST insert
        if (node == null) {
            return new AVLNode( key );
        }
        
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicates not allowed
        }
        
        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // Get the balance factor
        int balance = getBalance(node);
        
        // If the node becomes unbalanced, then there are 4 cases
        
        // Left-left  Case
        if (balance > 1 && key < node.left.data) {
            return rightRotate(node);
        }
        
        // Right-right  Case
        if (balance < -1 && key > node.right.data) {
            return leftRotate(node);
        }
        
        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        // Return the (unchanged) node pointer
        return node;
    }
    
    // Delete a node
    public AVLNode delete(AVLNode node, int key) {
        // Perform standard BST delete
        if (node == null) {
            return null;
        }
        
        if (key < node.data) {
            node.left = delete(node.left, key);
        } else if (key > node.data) {
            node.right = delete(node.right, key);
        } else {
            // Node with only one child or no child
            if ((node.left == null) || (node.right == null)) {
                
                // One child case
                return node.left != null ? node.left : node.right;
            }
            
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            AVLNode temp = minValueNode(node.right);
            node.data = temp.data; // Copy the inorder successor's data to this node
            node.right = delete(node.right, temp.data); // Delete the inorder successor
        }
        
        // If the tree has only one node, return it
        if (node == null) {
            return node;
        }
        
        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // Get the balance factor
        int balance = getBalance(node);
        
        // If the node becomes unbalanced, then there are 4 cases
        
        // Left - Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right - Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Get the node with the smallest value
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Search for a value
    public boolean search(AVLNode node, int key) {
        if (node == null) {
            return false;
        }
        
        if (key < node.data) {
            return search(node.left, key);
        } else if (key > node.data) {
            return search(node.right, key);
        } else {
            return true; // key is found
        }
    }
    
    // Public methods for insertion, deletion, and searching
    public void insert(int key) {
        root = insert(root, key);
    }
    
    public void delete(int key) {
        root = delete(root, key);
    }
    
    public boolean search(int key) {
        return search(root, key);
    }
    
    // Inorder traversal of the tree
    public void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    
    public void printInOrder() {
        inorder(root);
        System.out.println();
    }
    
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        
        System.out.println("Inorder traversal after insertion:");
        avlTree.printInOrder(); // Output: 10 20 25 30 40 50
        
        // Deletion
        avlTree.delete(10);
        System.out.println("Inorder traversal after deletion of 10:");
        avlTree.printInOrder(); // Output: 20 25 30 40 50
        
        avlTree.delete(30);
        System.out.println("Inorder traversal after deletion of 30:");
        avlTree.printInOrder(); // Output: 20 25 40 50
        
        // Searching
        System.out.println("Searching for 25: " + avlTree.search(25)); // Output: true
        System.out.println("Searching for 100: " + avlTree.search(100)); // Output: false
    }
}
