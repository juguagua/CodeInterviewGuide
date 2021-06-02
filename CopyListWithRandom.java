package Basics;

import java.util.HashMap;

public class CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int data){
            this.value = data;
        }
    }

    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null){         //将原链表节点与复制节点以键值对形式存入hash表
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            //利用hash表把复制节点串起来并加上rand指针
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);

    }

    public static Node copyListWithRand2(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node tmp = null;
        //复制节点并进行新旧连接
        while (cur != null){
            tmp = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = tmp;
            cur = tmp;
        }
        //设置新节点的rand节点
        cur = head;
        Node curCopy = null;
        while (cur != null){
            tmp = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand : null;
            cur = tmp;
        }
        //将新旧节点拆分开
        cur = head;
        Node res = cur.next;
        while (cur != null){
            curCopy = cur.next;
            tmp = cur.next.next;
            cur.next = tmp;
            curCopy.next = tmp != null ? tmp.next : null;
            cur = tmp;

        }
        return res;
    }

}
