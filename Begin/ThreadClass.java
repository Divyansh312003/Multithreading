package Multithreading.Begin;

public class ThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
