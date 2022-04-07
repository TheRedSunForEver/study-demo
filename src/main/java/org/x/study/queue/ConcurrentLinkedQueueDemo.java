package org.x.study.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue学习
 *
 * ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列。
 * 此队列按照FIFO（先进先出）对元素进行排序。新的元素插入到队列尾部，队列获取操作从队列头部获得元素。
 * 当多个线程共享访问一个公共collection时，ConcurrentLinkedQueue是一个恰当的选择。此队列不允许使用null元素。
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        demo1();
    }

    /**
     * offer，将指定元素插入此队列的尾部
     * poll，获取并移除队列的头，如果此队列为空，这返回null
     * peek，获取但不移除队列的头，如果此队列为空，这返回null
     * remove，从队列中移除指定元素（如果存在）
     *
     * size：返回队列中的元素数量
     *      如果队列包含的元素数大于Integer.MAX_VALUE，则返回Integer.MAX_VALUE
     *      与大多数collection不同，size方法不是一个固定的时间操作。由于队列的异步特性，确定当前元素需要进行一次花费O(n)的时间遍历
     *      在判断队列是否为空时，不要用queue.size() > 0，用!queue.isEmpty()
     *
     * contains，队列包含元素，返回true
     * iterator，元素迭代器
     *
     * ConcurrentLinkedQueue中add()和offer()完全一样，都是往队列尾部添加元素
     *
     */
    public static void demo1() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("a");
        System.out.println("offer后，队列是否为空？" + queue.isEmpty());
        System.out.println("从队列中poll: " + queue.poll());
        System.out.println("poll后，队列是否为空？" + queue.isEmpty());
        System.out.println("再次从队列中poll: " + queue.poll());

        queue.offer("b");
        System.out.println("offer后，队列是否为空？" + queue.isEmpty());
        System.out.println("peek: " + queue.peek());
        System.out.println("peek后，队列是否为空？" + queue.isEmpty());
    }
}
