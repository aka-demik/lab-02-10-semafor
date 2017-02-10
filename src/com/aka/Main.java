package com.aka;

import com.aka.math.Cubator;
import com.aka.math.Quadrator;
import com.aka.math.Simplerator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    Consumer[] consumers = { new Consumer() };
	    int[] ints = {1, 2, 3};
	    Thread[] threads = new Thread[6];
        threads[0] = new Thread(new Cubator(ints, consumers));
        threads[1] = new Thread(new Cubator(ints, consumers));
        threads[2] = new Thread(new Quadrator(ints, consumers));
        threads[3] = new Thread(new Quadrator(ints, consumers));
        threads[4] = new Thread(new Simplerator(ints, consumers));
        threads[5] = new Thread(new Simplerator(ints, consumers));

        for (Thread th:threads) {
            th.start();
        }

        for (Thread th:threads) {
            th.join();
        }

        System.out.println("Result: " + consumers[0].getSum());
    }
}
