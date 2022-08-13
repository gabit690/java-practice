package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Bank santander = new Bank();


        for (int count = 0; count < 10; count++) {

            Transaction t = new Transaction(santander, count);

            t.start();
        }
    }

}

class Bank {

    private double[] counts = new double[10];


    public Bank() {
        for(int index = 0; index < 10; index++) {
            counts[index] = 20000.00;
        }
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {

        while (counts[from] < amount) {

            wait();
        }
        counts[from]-=amount;
        counts[to]+=amount;
        System.out.println("Thread-" + Thread.currentThread().getName() + " Count" + from + " To Count" + to + " Amount " + amount + "Total Bank $" + getTotal());
        notifyAll();

    }

    public Double getTotal() {
        double total = 0;
        for (Double money: counts) {
            total += money;
        }
        return total;
    }
}

class Transaction extends Thread {

    private Bank source;

    private int count;

    public Transaction(Bank bank, int count) {

        this.source = bank;

        this.count = count;
    }

    @Override
    public void run() {

        while (true){

            int to = (int) (Math.random() * 10);
            double money = (int) (Math.random() * 1000) + 1;

            try {
                source.transfer(count, to, money);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}