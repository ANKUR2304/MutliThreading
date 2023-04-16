package com.example.multithreading;

public class MultiThreading1 {
    public static void main(String args[]){
        System.out.println("this code is executed on thread : " + Thread.currentThread().getName());

        // create new thread
        NewThread thread1 = new NewThread();

        // set thread parameters, exception handlers
        //thread1.setName("thread1");
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("A critical error happened in " + thread.getName() + " stating " + throwable.getMessage());
            }
        });

        // start thread1
        thread1.start();
    }

    public static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("this code is executed on thread : " + this.getName());
        }
    }
}