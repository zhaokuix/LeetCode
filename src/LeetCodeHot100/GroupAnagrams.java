package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    /**
     * 先排序，排好序的字母作为key，未排好序的放入value中，组成hashmap，
     * 最后直接在hashmap中取出结果即可
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //排序后的字符串
            String strSorted = new String(chars);
            List<String> list = map.get(strSorted);
            if (list == null){
                list = new ArrayList<>();
            }
            //将未排序的放入list
            list.add(str);
            map.put(strSorted,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));;
    }
}
