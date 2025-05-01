package org.example.tms.task1;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class MyThreadExt extends Thread{

    public MyThreadExt() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
