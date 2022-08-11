package threads;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String message = "Threads practice";

        int messageLength = message.length();

        for (int index = 0; index < messageLength; index++) {
            System.out.print(message.charAt(index));
            Thread.sleep(250);
        }

        System.out.println();

        DisplayClock clock1 = new DisplayClock("thread-2", 1000);

        Thread threadSecondary = new Thread(clock1);

        threadSecondary.start();

        Thread.sleep(8000);

        System.out.println("***** END *****");

    }

}

class DisplayClock implements Runnable {

    private String _id;

    private int _delay;

    public DisplayClock(String id, int delay) {
        this._id = id;
        this._delay = delay;
    }

    public void setDelay(int delay) {
        this._delay = delay;
    }

    public int getDelay() {
        return this._delay;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public void run() {
        for (int repetition = 1; repetition <= 5; repetition++) {
            try {
                Thread.sleep(this._delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[ " + this._id.toUpperCase() + " ]" + new Date());
        }
    }
}
