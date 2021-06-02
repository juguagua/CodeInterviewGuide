package Basics;

public class TrieTree {
    public class TrieNode{
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode(){
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }
    public class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.path++;    //节点伸出的路径
            int index = 0;
            for (int i = 0;i < chars.length;i++){
                index = chars[i] - 'a';
                if(node.map[index] == null){  //如果指定的路径另一端为空
                    node.map[index] = new TrieNode();//就给它创建一个节点
                }
                node = node.map[index];   //指向下一个节点
                node.path++;  //节点伸出路径++
            }
            node.end++;   //将末节点的end加一，表示以该节点为结尾的word

        }
        public boolean search(String word){
            if(word == null){
                return false;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0;i < chars.length;i++){
                index = chars[i] - 'a';
                if (node.map[index] == null){
                    return false;
                }
                node = node.map[index];
            }
            if (node.end != 0){
                return true;
            }else {
                return false;
            }

        }
        public void delete(String word){
            if (word == null || search(word) == false){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0;i < chars.length;i++){
                index = chars[i] - 'a';
                node.path--;
                if (node.path <= 0 ){
                    node.map = null;
                }
                node = node.map[index];
            }
            node.end--;
        }
        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0;i < chars.length;i++){
                index = chars[i] - 'a';
                if (node.map[index] == null){
                    return 0;
                }
                node = node.map[index];
            }
            return node.path;
        }
    }
}

