package Multithreading.Begin.ThreadCommunication;
class SharedResource{
    private int data;
    private boolean hasData;
    public synchronized  int consume(){
         while(!hasData){
             try{
                 wait();
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
         }
         hasData=false;
         System.out.println("Item consumed: "+data);
         notify();
         return data;
    }

    public synchronized  void produce(int value){
        while(hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData=true;
        data=value;
        System.out.println("Item produced: "+value);
        notify();
    }
}

class Producer implements Runnable{

    private SharedResource resource;
    public Producer(SharedResource sharedResource){
        this.resource=sharedResource;
    }


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{

    private SharedResource resource;
    public Consumer(SharedResource sharedResource){
        this.resource=sharedResource;
    }


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            resource.consume();
        }
    }
}
public class ThreadCommunication  {
    public static void main(String[] args) {
        SharedResource resource=new SharedResource();

        Thread produce=new Thread(new Producer(resource));
        Thread consume=new Thread(new Consumer(resource));
        produce.start();
        consume.start();
    }

}
