package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsPhoneNumber {
    /**
     * 使用队列完成字母的组合
     */
    public static List<String> letterCombinations(String digits) {
        //初始化键盘 map
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        //初始化队列
        Queue<String> queue = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            //获取字母
            String s = map.get(c);
            //队列为空时入队
            if (queue.isEmpty()){
                for (char c1 : s.toCharArray()) {
                    queue.add(c1 + "");
                }
            }else {
                //队列不为空时，先出队组合完后再入队
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //队首出队
                    String poll = queue.poll();
                    //遍历组合并入队
                    for (char c1 : s.toCharArray()) {
                        queue.add(poll + c1);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));
    }
}
