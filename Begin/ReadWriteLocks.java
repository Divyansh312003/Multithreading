package Multithreading.Begin;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
    private int count=0;
    private ReadWriteLock lock=new ReentrantReadWriteLock();
    private Lock readLock=lock.readLock();
    private Lock writeLock=lock.writeLock();

    public int getCount(){
        readLock.lock();
        try{
           return count;
        }
        finally {
          readLock.unlock();
        }
    }

    public void increment(){
        writeLock.lock();
        try{
            count++;
            Thread.sleep(50); //using this the reader threads will get chance to do the task
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            writeLock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLocks locks=new ReadWriteLocks();
        Runnable readTask=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" "+locks.getCount());
                }
            }
        };

        Runnable writeTask=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    locks.increment();
                    System.out.println(Thread.currentThread().getName()+" incremented");
                }
            }
        };

        Thread t1=new Thread(writeTask);
        Thread t2=new Thread(readTask);
        Thread t3=new Thread(readTask);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
