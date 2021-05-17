package com.wvd.saas.rbac.web;

public class ThreadPrint implements Runnable {
    private Boolean flag = false;
    private int numCount = 0;
    private Object lockObj;

    public ThreadPrint(Boolean flag, int numCount, Object lockObj) {
        this.flag = flag;
        this.numCount = numCount;
        this.lockObj = lockObj;
    }

    @Override
    public void run() {


        while (numCount <= 100) {
            synchronized(lockObj) {
                if (flag) {
                    flag = false;
                } else {
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(numCount);
                numCount = numCount + 2;

            lockObj.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object lockObj = new Object();
        Thread thread1 = new Thread(new ThreadPrint(true, 1, lockObj));
        Thread thread2 = new Thread(new ThreadPrint(false, 2, lockObj));

        thread2.start();
        thread1.start();

    }
}
