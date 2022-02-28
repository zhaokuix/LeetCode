package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 根据身高重建队列
 */
public class QueueReconstructionHeight {

    /**
     *假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，
     * 前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     * 对people按h降序、k升序进行排序，对于最高的i来说，i后面的人不会对他造成影响
     * 即我们放入第 i 个人时，只需要将其插入队列中，使得他的前面恰好有 k个人即可。
     */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people,(a,b) -> {
            if (a[0] != b[0]){
                return b[0] - a[0];
            }else {
                return a[1] - b [1];
            }
        });
        for (int[] person : people) {
            //将people[i]插入到位置k
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }
}
