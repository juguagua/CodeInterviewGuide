package Basics;

public class CompleteTreeNodeNumber {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }
    public static int bs(Node head,int level,int height){
        if (level == height){
            return 1;
        }
        if (mostLeftLevel(head.right,level + 1) == height){   //注意这里的高度是整体的高度，是绝对的值
            return (1 << (height - level) + bs(head.right,level + 1,height));
        }else {
            return (1 << (height - level - 1) + bs(head.left,level + 1,height));
        }
    }
    public static int mostLeftLevel(Node head,int level){
      while (head != null){
          level++;
          head = head.left;
      }
      return level - 1;
    }
}
