package Basics;

import java.util.Stack;

public class IsPalindromeList {
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }

    }
    // need n extra space
    public static boolean isPalindromeList1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean isPalindromeList2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node cur = head;
        Node right = head.next;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur  = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;

    }

    // need 1 extra space
    public static boolean isPalindromeList3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){   //find mid node
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;//把n2放到右边第一个节点的位置
        n1.next = null;  //中心节点置空
        Node n3 = null;  //创建一个新的辅助变量
        while (n2 != null){    //将右边的节点进行指针反向
            n3 = n2.next;    //先用n3保存住n2的下一个节点
            n2.next = n1;    //将n2的指针指向n1（即前一个）
            n1 = n2;         //将n1移动到n2的位置（即下一个）
            n2 = n3;         //将n2移动到n3的位置（即下一个）
        }  //此循环结束时，n2，n3都为空，n1指向最后一个节点
        n3 = n1;    //用n3保存最后一个节点的位置
        n2 = head;  //n2移动到头节点位置
        boolean res = true;
        while (n1 != null && n2 != null){   //n1向前走，n2向后走，检查是否回文
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //循环结束后，n1和n2都处于中间位置
        n1 = n3.next;  //n1放到n3.next上，即为倒数第二个
        n3.next = null;
        while (n1 != null){
            n2 = n1.next; //先用n2来临时保存n1的前一个节点
            n1.next = n3; //n3处于n1的后一个，进行连接
            n3 = n1;   //向前移动n3
            n1 = n2;   //向前移动n1
            n2 =  null;

        }

        return res;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

}
