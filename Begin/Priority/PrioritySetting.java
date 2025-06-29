package Multithreading.Begin.Priority;

public class PrioritySetting extends Thread{
    //setting name of the thread
    public PrioritySetting(String name){
        super(name);
    }
    @Override
    public void run() {
       for(int i=0;i<5;i++){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           String temp="";
           for(int j=0;j<100000;j++) temp+=""; //just for high work
           System.out.println(Thread.currentThread().getName()+" "+"priority "+ Thread.currentThread().getPriority()+" "+"count "+i);
       }
    }

    public static void main(String[] args) {
       PrioritySetting t1=new PrioritySetting("Divyansh");
        PrioritySetting t2=new PrioritySetting("Divyansh");
        PrioritySetting t3=new PrioritySetting("Divyansh");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t1.interrupt();
//        t2.interrupt();
//        t3.interrupt();
        //we can see in the output that the high priority thread gets completed first
        // so we can set the priority of threads accordingly

    }
}
