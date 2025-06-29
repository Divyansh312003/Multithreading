package Multithreading.Begin;

public class RunnableInterface implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
