class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Depth {
    public int maxdepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxdepth(root.left);
        int rightDepth = maxdepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void leaf(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        leaf(root.left);
        leaf(root.right);
    }
}

public class MaximumDepth {
    public static void main(String[] args) {
        Depth depth = new Depth();
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        System.out.println("Maximum depth : " + depth.maxdepth(root));
        System.out.print("Leaf nodes : ");
        depth.leaf(root);
        System.out.println();
    }
}
