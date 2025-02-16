package entecept_commun;

public class Consumer implements Runnable{
    private SharedMessage sharedMessage;

    public Consumer(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }

    @Override
    public void run() {
        String msg = null;
        do {
            try {
                msg = getSharedMessage().readMessage();
                System.out.println(msg);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has interrupted");
            }
        } while (!"Done".equals(msg));
    }

    public SharedMessage getSharedMessage() {
        return sharedMessage;
    }

    public void setSharedMessage(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }
}
