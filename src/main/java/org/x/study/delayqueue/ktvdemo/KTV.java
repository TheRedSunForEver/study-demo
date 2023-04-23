package org.x.study.delayqueue.ktvdemo;

import java.util.concurrent.DelayQueue;

public class KTV implements Runnable {
    private DelayQueue<KTVConsumer> queue = new DelayQueue<>();

    public void begin(String name, String boxNum, int money) {
        KTVConsumer man = new KTVConsumer(name, boxNum, 20 * money + System.currentTimeMillis());
        System.out.println(man.getName() + " 等人交了" + money + "元钱，分配" + man.getBoxNum() + "号包厢");
        this.queue.add(man);
    }

    public void end(KTVConsumer man) {
        System.out.println(man.getName() + " 等人交了所在的" + man.getBoxNum() + "号包厢，时间到");
    }

    @Override
    public void run() {
        while (true) {
            KTVConsumer man = null;
            try {
                man = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            end(man);
        }
    }

    public static void main(String[] args) {
        KTV ktv = new KTV();
        ktv.begin("zhangsan", "111", 500);
        ktv.begin("lisi", "666", 200);
        ktv.begin("wangwu", "888", 100);
        new Thread(ktv).start();

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
