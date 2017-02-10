package com.aka.math;

import com.aka.Consumer;

public class Quadrator implements Runnable {
    private final int[] ints;
    private final Consumer[] consumers;

    public Quadrator(int[] ints, Consumer[] consumers) {
        this.ints = ints;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int quad = i * i;
            for (Consumer cons: consumers) {
                cons.message(0, quad, 0);
            }
        }
    }
}
