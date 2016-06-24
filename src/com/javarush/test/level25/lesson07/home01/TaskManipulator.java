package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread taskManipulator;

    @Override
    public void run() {
        try {
            while (!taskManipulator.isInterrupted()){
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(90);
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void start(String threadName) {
        taskManipulator = new Thread(this, threadName);
        taskManipulator.start();
    }

    @Override
    public void stop() {
        taskManipulator.interrupt();
    }
}
