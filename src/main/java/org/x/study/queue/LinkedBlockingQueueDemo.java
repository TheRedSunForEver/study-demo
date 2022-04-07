package org.x.study.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 添加元素：
 * add: 如果队列已满，报java.lang.IllegalStateException: Queue full错误
 * offer：如果队列已满，程序正常运行，只是不在新增元素
 * put方法：如果队列已满，阻塞
 *
 * 取元素：
 * poll：弹出队顶元素，队列为空是返回null
 * peek：返回队顶元素，但顶元素不弹出，队列为空时返回null
 * take：当队列为空，阻塞
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        //addDemo(queue);
        //offerDemo(queue);
        //takeDemo(queue);
        putDemo(queue);
    }

    private static void putDemo(LinkedBlockingQueue<String> queue) {
        System.out.print("put: ");
        for (int i = 0; i < 10; i++) {
            try {
                String e = "" + i;
                queue.put(e);
                System.out.print(e + ",");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void takeDemo(LinkedBlockingQueue<String> queue) {
        System.out.print("take: ");
        for (int i = 0; i < 10; i++) {
            String e = null;
            try {
                e = queue.take();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.print(e + ",");
        }
    }

    private static void peekDemo(LinkedBlockingQueue<String> queue) {
        System.out.print("peek: ");
        for (int i = 0; i < 10; i++) {
            String e = queue.peek();
            System.out.print(e + ",");
        }
    }

    private static void pollDemo(LinkedBlockingQueue<String> queue) {
        System.out.print("poll: ");
        for (int i = 0; i < 10; i++) {
            String e = queue.poll();
            System.out.print(e + ",");
        }
    }

    private static void offerDemo(LinkedBlockingQueue<String> queue) {
        for (int i = 0; i < 10; i++) {
            queue.offer("" + i);
        }
        System.out.println(queue.size());
        printQueue(queue);
    }

    private static void addDemo(LinkedBlockingQueue<String> queue) {
        for (int i = 0; i < 10; i++) {
            queue.add("" + i);
        }
        System.out.println(queue.size());
    }

    private static void printQueue(LinkedBlockingQueue<String> queue) {
        for (String s : queue) {
            System.out.print(s + ",");
        }
        System.out.println();
    }
}
