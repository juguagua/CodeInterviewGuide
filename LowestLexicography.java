package Basics;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {
    public class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            return (a + b).compareTo(b + a);
        }
    }
    public String lowestString(String[] str){
        if (str == null || str.length == 0){
            return null;
        }
        Arrays.sort(str,new MyComparator());
        String res = "";
        for (int i = 0;i < str.length;i++){
            res += str[i];
        }
        return res;
    }
}
