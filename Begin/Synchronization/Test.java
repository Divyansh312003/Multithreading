package Multithreading.Begin.Synchronization;

public class Test extends Thread{
    @Override
    public void run() {
       for(int i=0;i<1000;i++) counter.increment();
    }

    private Counter counter;
    public Test(Counter c){
        this.counter=c;
    }



    public static void main(String[] args) {
        Counter count=new Counter();
        Test t1=new Test(count);
        Test t2=new Test(count);
        t1.start();
        t2.start();
        try{
            //used to print the task when all threads have completed their respective task
            t1.join();
            t2.join();
        }
        catch(Exception e){

        }
        //we will notice that without using the synchronized keyword we will get random values because
        // threads are running parallely and not in synchronized way so one picks up a value before the previous thread has overwritten it
        System.out.println(count.getCount());



    }
}
