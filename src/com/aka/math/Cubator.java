package com.aka.math;

import com.aka.Consumer;

public class Cubator implements Runnable {
    private final int[] ints;
    private final Consumer[] consumers;

    public Cubator(int[] ints, Consumer[] consumers) {
        this.ints = ints;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        for (int i : ints) {
            int cub = i * i * i;
            for (Consumer cons: consumers) {
                cons.message(cub, 0, 0);
            }
        }
    }
}
