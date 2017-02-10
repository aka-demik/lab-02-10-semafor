package com.aka;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {
    private AtomicInteger sum = new AtomicInteger(0);
    private AtomicBoolean lockCub = new AtomicBoolean(false);
    private AtomicBoolean lockQuad = new AtomicBoolean(false);
    private AtomicBoolean lockSimp = new AtomicBoolean(false);

    public void message(int cub, int quad, int simple) {
        if (cub != 0) {
            lockAndAdd(lockCub, cub);
        } else if (quad != 0) {
            lockAndAdd(lockQuad, quad);
        } else if (simple != 0) {
            lockAndAdd(lockSimp, simple);
        }
    }

    public int getSum() {
        return sum.get();
    }

    private void lockAndAdd(AtomicBoolean lock, int value) {
        while (!lock.compareAndSet(false, true)) {
            Thread.yield();
        }

        try {
            int currValue = sum.addAndGet(value);
            System.out.println("Current value: " + currValue);
        } finally {
            lock.set(false);
        }
    }
}
