package edu.umb.cs681.primes;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {

        long before, after;
        // Using a single thread
        System.out.println("Generating Prime numbers using a single thread");
        RunnablePrimeGenerator runnablePrimeGenerator1 = new RunnablePrimeGenerator(1, 2000000L);
        Thread thread1 = new Thread(runnablePrimeGenerator1);
        before = System.currentTimeMillis();
        thread1.start();
        try{
            thread1.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        after = System.currentTimeMillis();
        runnablePrimeGenerator1.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        long runningTimeForOneThread = (after - before);

        // Using two threads
        System.out.println("\n\n----------------------------------------------");
        System.out.println("\nGenerating Prime numbers using two threads");
        RunnablePrimeGenerator runnablePrimeGenerator2 = new RunnablePrimeGenerator(1, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator3 = new RunnablePrimeGenerator(1000000L, 2000000L);
        Thread thread2 = new Thread(runnablePrimeGenerator2);
        Thread thread3 = new Thread(runnablePrimeGenerator3);
        before = System.currentTimeMillis();
        thread2.start();
        thread3.start();
        try{
            thread2.join();
            thread3.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        after = System.currentTimeMillis();
        runnablePrimeGenerator2.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator3.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        long runningTimeForTwoThread = (after - before);

        // Using four threads
        System.out.println("\n\n----------------------------------------------");
        System.out.println("\nGenerating Prime numbers using four threads");
        RunnablePrimeGenerator runnablePrimeGenerator4 = new RunnablePrimeGenerator(1, 500000L);
        RunnablePrimeGenerator runnablePrimeGenerator5 = new RunnablePrimeGenerator(500000L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator6 = new RunnablePrimeGenerator(1000000L, 1500000L);
        RunnablePrimeGenerator runnablePrimeGenerator7 = new RunnablePrimeGenerator(1500000L, 2000000L);
        Thread thread4 = new Thread(runnablePrimeGenerator4);
        Thread thread5 = new Thread(runnablePrimeGenerator5);
        Thread thread6 = new Thread(runnablePrimeGenerator6);
        Thread thread7 = new Thread(runnablePrimeGenerator7);
        before = System.currentTimeMillis();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        try{
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        after = System.currentTimeMillis();
        runnablePrimeGenerator4.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator5.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator6.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator7.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        long runningTimeForFourThread = (after - before);

        // Using eight threads
        System.out.println("\n\n----------------------------------------------");
        System.out.println("\nGenerating Prime numbers using eight threads");
        RunnablePrimeGenerator runnablePrimeGenerator8 = new RunnablePrimeGenerator(1, 250000L);
        RunnablePrimeGenerator runnablePrimeGenerator9 = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator runnablePrimeGenerator10 = new RunnablePrimeGenerator(500000L, 750000L);
        RunnablePrimeGenerator runnablePrimeGenerator11 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator12 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator runnablePrimeGenerator13 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator runnablePrimeGenerator14 = new RunnablePrimeGenerator(1500000L, 1750000L);
        RunnablePrimeGenerator runnablePrimeGenerator15 = new RunnablePrimeGenerator(1750000L, 2000000L);
        Thread thread8 = new Thread(runnablePrimeGenerator8);
        Thread thread9 = new Thread(runnablePrimeGenerator9);
        Thread thread10 = new Thread(runnablePrimeGenerator10);
        Thread thread11 = new Thread(runnablePrimeGenerator11);
        Thread thread12 = new Thread(runnablePrimeGenerator12);
        Thread thread13 = new Thread(runnablePrimeGenerator13);
        Thread thread14 = new Thread(runnablePrimeGenerator14);
        Thread thread15 = new Thread(runnablePrimeGenerator15);
        before = System.currentTimeMillis();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        try{
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
            thread12.join();
            thread13.join();
            thread14.join();
            thread15.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        after = System.currentTimeMillis();
        runnablePrimeGenerator8.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator9.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator10.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator11.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator12.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator13.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator14.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator15.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        long runningTimeForEightThread = (after - before);

        // Using sixteen threads
        System.out.println("\n\n----------------------------------------------");
        System.out.println("Generating Prime numbers using sixteen threads");
        RunnablePrimeGenerator runnablePrimeGenerator16 = new RunnablePrimeGenerator(1, 125000L);
        RunnablePrimeGenerator runnablePrimeGenerator17 = new RunnablePrimeGenerator(125000L, 250000L);
        RunnablePrimeGenerator runnablePrimeGenerator18 = new RunnablePrimeGenerator(250000L, 375000L);
        RunnablePrimeGenerator runnablePrimeGenerator19 = new RunnablePrimeGenerator(375000L, 500000L);
        RunnablePrimeGenerator runnablePrimeGenerator20 = new RunnablePrimeGenerator(500000L, 625000L);
        RunnablePrimeGenerator runnablePrimeGenerator21 = new RunnablePrimeGenerator(625000L, 750000L);
        RunnablePrimeGenerator runnablePrimeGenerator22 = new RunnablePrimeGenerator(750000L, 875000L);
        RunnablePrimeGenerator runnablePrimeGenerator23 = new RunnablePrimeGenerator(875000L, 1000000L);
        RunnablePrimeGenerator runnablePrimeGenerator24 = new RunnablePrimeGenerator(1000000L, 1125000L);
        RunnablePrimeGenerator runnablePrimeGenerator25 = new RunnablePrimeGenerator(1125000L, 1250000L);
        RunnablePrimeGenerator runnablePrimeGenerator26 = new RunnablePrimeGenerator(1250000L, 1375000L);
        RunnablePrimeGenerator runnablePrimeGenerator27 = new RunnablePrimeGenerator(1375000L, 1500000L);
        RunnablePrimeGenerator runnablePrimeGenerator28 = new RunnablePrimeGenerator(1500000L, 1625000L);
        RunnablePrimeGenerator runnablePrimeGenerator29 = new RunnablePrimeGenerator(1625000L, 1750000L);
        RunnablePrimeGenerator runnablePrimeGenerator30 = new RunnablePrimeGenerator(1750000L, 1875000L);
        RunnablePrimeGenerator runnablePrimeGenerator31 = new RunnablePrimeGenerator(1875000L, 2000000L);
        Thread thread16 = new Thread(runnablePrimeGenerator16);
        Thread thread17 = new Thread(runnablePrimeGenerator17);
        Thread thread18 = new Thread(runnablePrimeGenerator18);
        Thread thread19 = new Thread(runnablePrimeGenerator19);
        Thread thread20 = new Thread(runnablePrimeGenerator20);
        Thread thread21 = new Thread(runnablePrimeGenerator21);
        Thread thread22 = new Thread(runnablePrimeGenerator22);
        Thread thread23 = new Thread(runnablePrimeGenerator23);
        Thread thread24 = new Thread(runnablePrimeGenerator24);
        Thread thread25 = new Thread(runnablePrimeGenerator25);
        Thread thread26 = new Thread(runnablePrimeGenerator26);
        Thread thread27 = new Thread(runnablePrimeGenerator27);
        Thread thread28 = new Thread(runnablePrimeGenerator28);
        Thread thread29 = new Thread(runnablePrimeGenerator29);
        Thread thread30 = new Thread(runnablePrimeGenerator30);
        Thread thread31 = new Thread(runnablePrimeGenerator31);
        before = System.currentTimeMillis();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();
        thread20.start();
        thread21.start();
        thread22.start();
        thread23.start();
        thread24.start();
        thread25.start();
        thread26.start();
        thread27.start();
        thread28.start();
        thread29.start();
        thread30.start();
        thread31.start();
        try{
            thread16.join();
            thread17.join();
            thread18.join();
            thread19.join();
            thread20.join();
            thread21.join();
            thread22.join();
            thread23.join();
            thread24.join();
            thread25.join();
            thread26.join();
            thread27.join();
            thread28.join();
            thread29.join();
            thread30.join();
            thread31.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        after = System.currentTimeMillis();
        runnablePrimeGenerator16.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator17.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator18.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator19.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator20.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator21.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator22.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator23.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator24.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator25.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator26.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator27.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator28.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator29.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator30.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        runnablePrimeGenerator31.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
        long runningTimeForSixteenThread = (after - before);

        System.out.println("\n\n---Running Time---");
        System.out.println("For 1 Thread: " + runningTimeForOneThread);
        System.out.println("For 2 Thread: " + runningTimeForTwoThread);
        System.out.println("For 4 Thread: " + runningTimeForFourThread);
        System.out.println("For 8 Thread: " + runningTimeForEightThread);
        System.out.println("For 16 Thread: " + runningTimeForSixteenThread);

    }

}
