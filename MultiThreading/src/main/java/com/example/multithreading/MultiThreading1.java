package com.example.multithreading;

public class MultiThreading1 {
    public static void main(String args[]){
        // create new thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception");
            }
        });

        // set thread parameters, exception handlers
        thread1.setName("thread1");
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("A critical error happened in " + thread.getName() + " stating " + throwable.getMessage());
            }

        });

        // start thread1
        thread1.start();
    }
}