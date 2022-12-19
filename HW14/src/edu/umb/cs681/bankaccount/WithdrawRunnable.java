package edu.umb.cs681.bankaccount;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable {

    private BankAccount bankAccount;
    private ReentrantLock lock = new ReentrantLock();
    private AtomicBoolean done = new AtomicBoolean(false);

    public WithdrawRunnable(BankAccount bankAccount) {
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
                System.out.println("Money Withdrawn -- Exiting WithdrawRunnable");
                break;
            }
            this.bankAccount.withdraw(500);
            System.out.println("Money withdraw request successful");
        }
    }

}
