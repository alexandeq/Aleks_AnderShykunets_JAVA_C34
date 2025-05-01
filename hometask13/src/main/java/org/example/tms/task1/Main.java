package org.example.tms.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread threadImpl = new Thread(new MyThreadImpl(), "Impl");
        threadImpl.start();

        Thread threadExt = new MyThreadExt();
        threadExt.setName("Ext");
        threadExt.start();


        threadExt.join();
        threadImpl.join();
        System.out.println("main end");

    }
}