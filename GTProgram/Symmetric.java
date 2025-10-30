import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class SymmetricTree {

    public boolean isSymmetric(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            Node t1 = queue.poll();
            Node t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.data != t2.data) {
                return false;
            } else {
                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
        }
        return true;
    }
}

public class Symmetric {
    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        // root.right.left = new Node(4);
        root.right.right = new Node(1);

        System.out.println(symmetricTree.isSymmetric(root));
    }
}
