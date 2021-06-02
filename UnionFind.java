package Basics;


import javafx.scene.chart.ValueAxis;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Element<V>{    //定义一个元素类，V表示哈希表中的value变量，与定义Node无异
        public V value;
        public Element(V value){
            this.value = value;
        }
    }

    public static class UnionFindSet<V>{  //要在类名后面加泛型方可使用特殊变量V
        public HashMap<V,Element<V>> elementMap;
        public HashMap<Element<V>,Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list){   //传进来一个list，其中元素为V变量
            elementMap = new HashMap<>();    //对三个哈希表进行初始化
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list){          //for循环为每一个变量创建对应的element，并对其初始化
                Element<V> element = new Element<>(value);
                elementMap.put(value,element);  // 以值val为key，包装类型ele为value
                fatherMap.put(element,element); //初始时各结点自己为一个集合，将父节点设为自己
                rankMap.put(element,1);
            }
        }
        public Element<V> findHead(Element<V> element){  //在找父节点的过程中进行优化设计
            Stack<Element<V>> path = new Stack<>();   //利用一个stack存放路径结点
            while (fatherMap.get(element) != element){
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(),element);    //将路径结点的父节点全部置为代表结点，
                                                // 使得路径上的每个节点在下次查找时只需要经过一次移动，最重要优化
            }
            return element;
        }
        public boolean isSameSet(V a,V b){
            if (elementMap.containsKey(a) && elementMap.containsKey(b)){
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }
        public Element<V> union(V a,V b){
            Element<V> aF = findHead(elementMap.get(a));
            Element<V> bF = findHead(elementMap.get(b));
            if (aF == bF){
                return aF;
            }
            else {
                Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small,big);
                rankMap.put(big,rankMap.get(big) + rankMap.get(small));
                rankMap.remove(small);
                return big;
            }
        }
    }
}
