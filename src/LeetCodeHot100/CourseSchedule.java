package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * 拓扑排序
 */
public class CourseSchedule {

    /**
     * 一共有 n 门课要上，编号为 0 ~ n-1。
     * 先决条件[1, 0]，意思是必须先上课 0，才能上课 1。
     * 给你 n 、和一个先决条件表，请你判断能否完成所有课程。
     *
     * 示例：n = 6，先决条件表：[[3, 0], [3, 1], [4, 1], [4, 2], [5, 3], [5, 4]]
     * 0
     *    \
     *      3
     *    /     \
     * 1          5
     *    \     /
     *      4
     *    /
     * 2
     * 这种图叫有向无环图，把一个有向无环图转成线性就叫  拓扑排序
     * 有向图右入度和出度的概念：如果存在一条有向边A-->B,则这条边给A增加了一个出度，给B增加了一个入度
     * 所以顶点0、1、2的入度为0，顶点3、4、5的入度为2
     * 每次只能选入度为0的课，因为它不依赖于别的课，是当下你能上的课。
     * 假设选0: 3的先修课就少了一门，入度由2变成1
     * 接着选1，导致3的入度变成0，4的入度由2变成1
     * 接着选2，导致4的入度变成0。
     * 现在3和4的入度都是0，继续选入度为0的课，直到选不到入度为0的课。
     *
     * 这很像 BFS：
     * 让入度为 0 的课入列，它们是能直接选的课。
     * 然后逐个出列，出列代表着课被选，需要减小相关课的入度。
     * 如果相关课的入度新变为 0，安排它入列、再出列……直到没有入度为 0 的课可入列。
     *
     * 入度用数组存储：课号 0 到 n - 1 作为索引，通过遍历先决条件表求出对应的初始入度。
     * 邻接表：用map(key+链表)存储依赖关系，比如0-->[3]、1-->[3,4]
     *
     * 如何判断能否进行拓扑排序（修完所有的课）：
     * 1、BFS结束时，如果存在入度不为0的课，那么就没法修完所有的课
     * 2、用一个变量count记录顶点个数最后判断，最后判断count是否等于课程数
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度数组
        int[] inDegree = new int[numCourses];
        //邻接表(map)
        Map<Integer, List<Integer>> map = new HashMap<>();
        //记录顶点个数,最后判断count是否等于课程数
        int count = 0;
        //入度数组初始化
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        //邻接表初始化
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.get(prerequisite[1]);
            if (list == null){
                list = new ArrayList<>();
            }
            if (!list.contains(prerequisite[0])){
                list.add(prerequisite[0]);
            }
            map.put(prerequisite[1],list);
        }

        //声明一个队列用于bfs
        Queue<Integer> queue = new ArrayDeque<>();
        //将入度为0的课程加入queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            //选一门课程
            Integer courseI = queue.poll();
            //计数器+1
            count++;
            //修改该门课程邻接课程的入度
            List<Integer> list = map.get(courseI);
            if (list != null){
                for (Integer courseJ : list) {
                    inDegree[courseJ]--;
                    //如果修改完后入度变成了0，将该门课程加入queue
                    if (inDegree[courseJ] == 0){
                        queue.add(courseJ);
                    }
                }
            }
        }
        //判断是否遍历完
        return count == numCourses;
    }
}
