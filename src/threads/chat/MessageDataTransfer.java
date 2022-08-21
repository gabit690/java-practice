package threads.chat;

import java.io.Serializable;

public class MessageDataTransfer implements Serializable {

    private static final Long serialVersionUID = 1L;

    private int portOutput;

    private int portDestiny;

    private Message content;

    public MessageDataTransfer(int portOutput, int portDestiny, Message content) {
        this.portOutput = portOutput;
        this.portDestiny = portDestiny;
        this.content = content;
    }

    public int getPortOutput() {
        return portOutput;
    }

    public void setPortOutput(int portOutput) {
        this.portOutput = portOutput;
    }

    public int getPortDestiny() {
        return portDestiny;
    }

    public void setPortDestiny(int portDestiny) {
        this.portDestiny = portDestiny;
    }

    public Message getContent() {
        return content;
    }

    public void setContent(Message content) {
        this.content = content;
    }
}
