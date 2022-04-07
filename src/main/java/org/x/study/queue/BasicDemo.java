package org.x.study.queue;

/**
 * Queue：先入先出（FIFO）的数据结构
 * Queue接口与List、Set同一级别，都继承了Collection接口
 *
 * 在并发队列上，JDK提供了2套实现，一个是以ConcurrentLinkedQueue为代表的高性能非阻塞队列
 * 一个是以BlockingQueue接口为代表的阻塞队列；
 *
 * ConcurrentLinkedQueue
 *   一个适用于高并发场景下的队列，通过无锁（CAS+volatile)，实现了高并发下的高性能，通常
 *   ConcurrentLinkedQueue的性能好于BlockingQueue。
 *   size（）不是常量时间的花费，而是O(N)；
 *   虽然使用了CAS+volatile的机制避免了锁，但是我们要明白的是，这个只是保证单个操作，如peek()
 *   的安全，多个操作想保证的话，需要使用锁机制达到同步的效果；
 *
 * ArrayBlockingQueue
 *   基于数据的阻塞队列实现，在其内部维护了一个定长数组，以便缓存队列中的数据对象，由于ArrayBlockingQueue内部只有
 *   一个锁对象（ReentrantLock），因此读写没有实现分离，也就意味生产消费不能完全并行。由于长度需要定义，因此也叫有界队列。
 *
 * LinkedBlockingQueue
 *   基于链表的阻塞队列实现，LinkedBlockingQueue之所以较ArrayBlockingQueue更加高效的处理并发数据，
 *   是因为内部实现采用了2把锁，也就是实现了入队、出队分别上锁，即读写分离，从而生产者、消费者完全到达了并行。
 *
 * DelayQueue
 *   带有延迟时间的Queue，其中元素只有当指定的时间到了，才能从队列中获取到该元素。队列中的元素必须实现Delayed接口，没有大小限制。
 */
public class BasicDemo {
}
