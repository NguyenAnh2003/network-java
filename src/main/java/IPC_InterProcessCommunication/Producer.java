package IPC_InterProcessCommunication;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public synchronized void produce() throws InterruptedException{
            for(int i = 1; i<=10; i++) {
                Message mess = new Message(i);
                this.queue.put(mess.getData());
                System.out.println("Produced " + mess.getData());
            }
            sleep(1000);
    }

    private void sleep(long timeMilis) {
        try {
            Thread.sleep(timeMilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
