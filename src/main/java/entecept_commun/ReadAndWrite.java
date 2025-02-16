package entecept_commun;

public class ReadAndWrite {
    public static void main(String[] args)  {
        SharedMessage sharedMessage = new SharedMessage("Init msg");
        Consumer consumer = new Consumer(sharedMessage);
        Producer producer = new Producer(sharedMessage);
        Thread thread = new Thread(consumer);
        Thread thread2 = new Thread(producer);
        thread.start();
        thread2.start();
    }
}

