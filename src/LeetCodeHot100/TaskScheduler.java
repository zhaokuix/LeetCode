package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/task-scheduler/
 * 任务调度器
 *
 * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 * 示例 1：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 */
public class TaskScheduler {
    /**
     *分情况讨论
     * 本题核心问题就是冷却时间n意味着CPU可能必须要待命,实际完成任务时间 = len(tasks)+待命 > len(tasks);
     * 如果不需要待命,实际完成任务时间 = len(tasks)
     * 假设需要待命 ,由数量最大的任务种类来决定完成任务时间:
     * 假设 A有3个(maxCt = 3), n = 2, 需要 待命 说明'x'的位置都填不满, 实际完成任务时间 = (maxCt-1)*(n+1)+1 > len(tasks)
     * A x x
     * A x x
     * A
     *
     * 如果'x'的位置能填满的话, 实际完成任务时间 = len(tasks) > (maxCt-1)*(n+1)+1, e.g.
     * A B C D
     * A B C
     * A
     *
     * 另外要注意的是数量最大的任务可能有好几个, 比如A有3个(maxCt = 3), B也有3个, eleMaxCt = 2,
     * A B x
     * A B x
     * A B
     * 那么最后一行的个数就不是1,而是eleMaxCt,
     * 综上, 实际完成任务时间 = max((maxCt-1)*(n+1)+eleMaxCt , len(tasks))
     *
     */
    public int leastInterval(char[] tasks, int n) {
        //任务最大重复数
        int maxCt = 0;
        //等于任务最大重复数的任务的种类
        int eleMaxCt = 0;
        //1、求任务最大重复数
        Map<Character,Integer> map = new HashMap<>();
        for (char c : tasks) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c,count);
            maxCt = Math.max(count,maxCt);
        }
        //求 等于任务最大重复数的任务的种类
        for (Character c : map.keySet()) {
            if (map.get(c).equals(maxCt)){
                eleMaxCt++;
            }
        }
        return Math.max((maxCt-1)*(n+1)+eleMaxCt , tasks.length);
    }
}
