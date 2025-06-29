package Multithreading.Begin.FairAndUnfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//in this example we have fairness -> means that all the threads in order  enter the C.S. and do their stuff which what we want
public class FairnessExample {
    private static Lock fairLock=new ReentrantLock(true);
    public static void main(String[] args) {
        FairnessExample example=new FairnessExample();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" "+"acquired the lock");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName()+" "+"released the lock");
                    fairLock.unlock();
                }

            }
        };

        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
        Thread t3=new Thread(task,"Thread 3");
        t3.start();
        t2.start();
        t1.start();

    }
}

