package org.x.study.delayqueue.ktvdemo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class KTVConsumer implements Delayed {
    private String name;
    private long endTime;
    private String boxNum;

    public KTVConsumer() {
    }

    public KTVConsumer(String name, String boxNum, long endTime) {
        this.name = name;
        this.boxNum = boxNum;
        this.endTime = endTime;
    }

    /**
     * 用来判断是否到了截止时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(endTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 相互比较排序使用
     */
    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 1;
        }

        if (o == this) {
            return 0;
        }

        KTVConsumer s = (KTVConsumer) o;
        return Long.compare(this.endTime, s.endTime);
    }

    public String getName() {
        return name;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getBoxNum() {
        return boxNum;
    }
}
