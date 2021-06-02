package Basics;

public class IsBalancedTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 0,res);
        return res[0];

    }
    public static int getHeight(Node head,int level,boolean[] res){
        if (head == null){
            return level ;
        }
        int lH = getHeight(head.left,level + 1,res) ;
        if (!res[0]){
            return level;
        }
        int rH = getHeight(head.right,level + 1,res) ;
        if (!res[0]){
            return level;
        }
        if (Math.abs(lH - rH) > 1){
            res[0] = false;
        }
        return Math.max(lH,rH);
    }
}
