package Basics;

public class SmallEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node listPartition1(Node head,int pivot){
        if (head == null){
            return null;
        }
        Node cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        cur = head;
        for (i = 0;i < nodeArr.length;i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for (i = 1;i != nodeArr.length;i++){
            nodeArr[i - 1].next = nodeArr[i];   //此处巧妙，因数组内为Node元素，直接将之连接即可，不用向原链表复制
        }
        nodeArr[i - 1].next = null;   //因为nodearr[i]处没有值，所以需要给i - 1处设置next
        return nodeArr[0];

    }
    public static void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big){
            if (nodeArr[index].value < pivot){
                swap(nodeArr,index++,++small);
            }else if (nodeArr[index].value > pivot){
                swap(nodeArr,index,--big);
            }else {
                index++;
            }
        }
    }
    public static void swap(Node[] arr,int a,int b){
        Node tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node next = null;   // 用next节点来保存主链表的下一个节点，向后进行推进
        while (head != null){
           next = head.next;
           head.next = null;  //将当前节点孤立出来
           if (head.value < pivot){
               if (sH == null){
                   sH = head;
                   sT = head;
               }else {
                   sT.next = head;
                   sT = head;
               }
           }else if (head.value == pivot){
               if (eH == null){
                   eH = head;
                   eT = head;
               }else {
                   eT.next = head;
                   eT = head;
               }
           }else {
               if (bH == null){
                   bH = head;
                   bT = head;
               }else {
                   bT.next = head;
                   bT = head;
               }
           }
           head = next;
        }
        //排序完成后将三条链表重新合在一起

        if (sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null){
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;

    }
    public static void printLinkedList(Node head){
        System.out.print("Linked list :");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
