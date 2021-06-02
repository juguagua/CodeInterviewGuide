package Basics;

import java.util.HashMap;

public class RandomPool {
    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<K,Integer>();
            this.indexKeyMap = new HashMap<Integer,K>();
            this.size = 0;
        }

        public void insert(K key){
            if (!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(size++,key);
            }
        }
        public void delete(K key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);  //两个哈希表的目的正在于此，找到要替换被删除元素的key值
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);

            }
        }
        public K getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomIndex = (int)(Math.random()*this.size);
            return this.indexKeyMap.get(randomIndex);
        }

    }
}
