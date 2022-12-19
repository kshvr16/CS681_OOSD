package edu.umb.cs681.bankaccount;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {

    private BankAccount bankAccount;
    private ReentrantLock lock = new ReentrantLock();
    private AtomicBoolean done = new AtomicBoolean(false);

    public DepositRunnable(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setDone() {
        this.lock.lock();
        try {
            this.done.set(true);
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        while(true) {
            if(this.done.get()) {
                System.out.println("Money deposited -- Exiting DepositRunnable");
                break;
            }
            this.bankAccount.deposit(500);
            System.out.println("Money deposit request successful");
        }
    }

}
