package org.example.tms.task1;

import lombok.Getter;

public class MyThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
