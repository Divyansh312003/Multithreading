package Multithreading.Begin.Lambda;

public class LambdaExp {
    public static void main(String[] args) {
        //aam zindagi
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        Thread t1=new Thread(runnable);
        t1.start();

        //mentos zindagi
        Runnable runnable1= () -> System.out.println("Hello ji");
        Thread t2=new Thread(runnable1);
        t2.start();
        //Runnable is a functional Interface which contains only a single abstract method
        //so they can be written as lambda expression



    }
}
