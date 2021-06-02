package Basics;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.Stack;

public class PreInPosTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order");
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }

            }
        }
        System.out.println();
    }
    public static void inOrderUnRecur(Node head) {
        System.out.println("in-order");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (head != null || !stack.isEmpty()) {
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order");
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            Stack<Node> stackTmp = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                stackTmp.push(head);
                if (head.left != null){
                    stack.push(head.left);
                }
                if (head.right != null){
                    stack.push(head.right);
                }
            }
            while (!stackTmp.isEmpty()){
                head = stackTmp.pop();
                System.out.println(head.value + " ");
            }
        }
        System.out.println();
    }
}
