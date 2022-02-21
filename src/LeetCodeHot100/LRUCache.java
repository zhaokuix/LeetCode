package LeetCodeHot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 哈希表加双向链表实现。
 * 对时间的判断，数据get后节点放到头部，put的数据直接放到头部
 * 如果容量超出，就把最后一个节点去掉。
 * 同时多声明一个head和tail节点，方便使用。
 *
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
 * 如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    //存储数据
    private final HashMap<Integer, DListNode> map;

    //容量
    private final int capacity;

    //当前存储的数量
    private int currentNums;

    //声明链表head和tail方便使用
    private final DListNode head;

    private final DListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.currentNums = 0;
        this.head = new DListNode();
        this.tail = new DListNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node != null) {
            //node不为空将节点放到链表head处再返回数据
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        //判断是否存在此节点
        DListNode node = map.get(key);
        if (node != null) {
            node.value = value;
            //移动到头节点
            moveToHead(node);
        } else {
            //如果不存在，添加新的节点
            node = new DListNode(key, value);
            //添加到头节点
            addToHead(node);
            //如果当前节点数量超过容量，删除最后一个节点
            if (currentNums > capacity) {
                deleteTail();
            }
        }
    }

    /**
     * 添加到头节点
     */
    private void addToHead(DListNode node) {
        DListNode oldNext = head.next;
        oldNext.pre = node;
        node.next = oldNext;
        node.pre = head;
        head.next = node;
        map.put(node.key, node);
        //当前节点数+1
        ++currentNums;
    }

    /**
     * 移动到头节点
     */
    private void moveToHead(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    /**
     * 删除最后一个节点
     */
    private void deleteTail() {
        DListNode prePre = tail.pre.pre;
        //如果prePre等于null说明只存在默认的head和tail两个节点，无需处理。
        //因此只判断 prePre != null 这一个条件即可。
        if (prePre != null){
            //在map中删除最后一个节点
            map.remove(prePre.next.key);
            prePre.next = tail;
            tail.pre = prePre;
            //当前节点数-1
            --currentNums;
        }
    }

    class DListNode {
        Integer key;
        Integer value;
        DListNode pre;
        DListNode next;

        public DListNode() {
        }

        public DListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
    }
}
