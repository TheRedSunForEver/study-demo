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
     */
    public static void demo1() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("a");
        System.out.println("offer后，队列是否为空？" + queue.isEmpty());
        System.out.println("从队列中poll: " + queue.poll());
        System.out.println("poll后，队列是否为空？" + queue.isEmpty());
        System.out.println("再次从队列中poll: " + queue.poll());
    }
}
