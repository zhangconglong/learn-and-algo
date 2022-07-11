package 题集.牛客.大厂系统设计.SP1_某云ES倒排索引;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
[1, 5, 4, 9],["My lover", "Yours", "you are young", "My old age"],"My"

[1, 9]
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param ID      int整型ArrayList
     * @param content string字符串ArrayList
     * @param word    string字符串
     * @return int整型ArrayList
     */
    public ArrayList<Integer> invertedIndex(ArrayList<Integer> ID, ArrayList<String> content, String word) {
        Map<String, ArrayList> indexMap = new HashMap<>();

        for (int i = 0; i < content.size(); i++) {
            int index = ID.get(i);
            String[] s = content.get(i).split(" ");

            for (String s1 : s) {
                ArrayList<Integer> list = new ArrayList<>();

                if (indexMap.containsKey(s1)) { //之前有
                    list = indexMap.get(s1);
                    if (!list.contains(index)) {
                        list.add(index);
                    }
                }else {
                    list.add(index);
                }
                indexMap.put(s1, list);
            }
        }

        if (indexMap.containsKey(word)) {
            return indexMap.get(word);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Integer> ID = new ArrayList<>();
        ID.add(1);
        ID.add(5);
        ID.add(4);
        ID.add(9);
        ArrayList<String> Content = new ArrayList<>();
        Content.add("This is the content of document 1 it is very short");
        Content.add("This is the");

        Solution solution = new Solution();
        solution.invertedIndex(ID, Content, "is").forEach( integer -> {
            System.out.println(integer);
        });
    }
}