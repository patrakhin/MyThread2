package entecept_commun;


import java.io.IOException;
import java.util.List;

public class Producer implements Runnable {
    private SharedMessage sharedMessage;

    public Producer(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }

    @Override
    public void run() {
        List<String> messageList = List.of("Message_1", "Message_2", "Message_3");
        for (String message : messageList) {
            try {
                getSharedMessage().writeMessage(message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has interrupted");
            }
        }
        getSharedMessage().writeMessage("Done");
    }

    public SharedMessage getSharedMessage() {
        return sharedMessage;
    }

    public void setSharedMessage(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }
}
