package IPC_InterProcessCommunication.Producer_Consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void consume() throws InterruptedException{
        for(int i = 1; i<=10; i++) {
            int num = this.queue.take();
            System.out.println("Consumed " + num);
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
