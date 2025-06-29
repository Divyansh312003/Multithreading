package Multithreading.Begin;

public class Test {
    public static void main(String[] args) {

        //for Thread class
        ThreadClass threadClass=new ThreadClass();
        threadClass.start();

        //for Runnable interface
        RunnableInterface runnableInterface=new RunnableInterface();
        Thread t1=new Thread(runnableInterface);
        t1.start();

        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
