package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    /**
     * 合并区间
     * 按左区间排序，能合并的肯定都是挨在一起的
     * 遍历区间，找能合并的，合并后标记为已使用。
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        //intervals按左区间排序
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int[] a, int[] b){
        //         return a[0] - b[0];
        //     }
        // });
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        //存放合并后的区间
        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < intervals.length; ) {
            int[] tmp = {intervals[i][0], intervals[i][1]};
            //右指针 j
            int j = i + 1;
            while (j < intervals.length) {
                int[] jArray = intervals[j];
                //tmp右区间大于或等于jArray左区间时可以合并，可以合并的肯定是连续的，因为已经排序了
                if (tmp[1] >= jArray[0]){
                    tmp[1] = Math.max(tmp[1], jArray[1]);
                }else {
                    i = j;
                    break;
                }
                j++;
            }
            //合并后的数组放入集合中
            ansList.add(tmp);
            //如果右指针j遍历到头了，说明已经合并完了
            if (j == intervals.length){
                break;
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
