package entecept_commun;

public class SharedMessage {
    private String message;
    //isEmpty = false (Producer doing), isEmpty = true (Consumer doing)
    private boolean isEmpty = true;
    public SharedMessage(String message) {
        this.message = message;
    }

    public synchronized String readMessage() {
        while (!isEmpty){
            try {
                System.out.println("Waiting for Producer");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was read");
            }
        }
        isEmpty = false;
        notifyAll();
        return message;
    }

    public synchronized void writeMessage(String message) {
        while (isEmpty){
            try {
                System.out.println("Waiting for write");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted");
            }
        }
        setMessage(message);
        isEmpty = true;
        notifyAll();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
