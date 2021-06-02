package Basics;

public class SuccessorNode {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data){
            this.value = data;
        }
    }
    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){
            return getMostLeftNode(node.right);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    public static Node getMostLeftNode(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur.left != null){
            cur = cur.left;
        }

        return cur;
    }
}
