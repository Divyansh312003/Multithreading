package Multithreading.Begin.FairAndUnfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//in this example we dont have fairness -> means that all the threads randomly enter the C.S. and do their stuff which is not correct
public class UnfairnessExample {
    private static Lock unfairLock=new ReentrantLock();
    public static void main(String[] args) {
        UnfairnessExample example=new UnfairnessExample();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                 unfairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" "+"acquired the lock");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName()+" "+"released the lock");
                    unfairLock.unlock();
                }

            }
        };

        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
        Thread t3=new Thread(task,"Thread 3");
        t1.start();
        t2.start();
        t3.start();

    }
}
