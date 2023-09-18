package IPC_InterProcessCommunication.Producer_Consumer;

public class Message {
    private int data;

    public Message(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
