package com.aka.math;

import com.aka.Consumer;

public class Simplerator implements Runnable {
    private final int[] ints;
    private final Consumer[] consumers;

    public Simplerator(int[] ints, Consumer[] consumers) {
        this.ints = ints;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        for (int i : ints) {
            for (Consumer cons: consumers) {
                cons.message(0, 0, i);
            }
        }
    }
}
