package org.x.study.delayqueue;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        DelayQueue<Obj> queue = new DelayQueue<>();

        CompletableFuture.runAsync(() -> {
            for (int i = 5; i < 30; i += 5) {
                System.out.println("放入队列" + i);
                Obj o = new Obj(i, TimeUnit.SECONDS, "name_" + i);
                queue.put(o);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        CompletableFuture.runAsync(() -> {
            while (true) {
                Obj o = null;
                try {
                    o = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(o);
            }
        });

        System.in.read();
    }


    public static class Obj implements Delayed {
        private long time;
        private String name;

        public Obj(long time, TimeUnit unit, String name) {
            this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
            this.name = name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.time, ((Obj)o).time);
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "time=" + time +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
