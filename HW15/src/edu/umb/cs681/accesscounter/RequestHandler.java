package edu.umb.cs681.accesscounter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean done = false;

    public void setDone() {
        this.lock.lock();
        try {
            this.done = true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        AccessCounter accessCounter = AccessCounter.getInstance();
        Random random = new Random();
        while(true) {
            this.lock.lock();
            try {
                if(done) {
                    System.out.println("Stopped accessing the files");
                    break;
                }
                int no_of_files = 5;
                int random_file = random.nextInt(no_of_files);
                String file_name = "dummy_" + random_file + ".txt";
                Path path = Paths.get(file_name);
                accessCounter.increment(path);
                int count = accessCounter.getCount(path);
                System.out.println("Count: " + count);
            } finally {
                this.lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
        }
    }

    public static void main(String[] args) {
        RequestHandler requestHandlerOne = new RequestHandler();
        Thread threadOne = new Thread(requestHandlerOne);

        RequestHandler requestHandlerTwo = new RequestHandler();
        Thread threadTwo = new Thread(requestHandlerTwo);

        RequestHandler requestHandlerThree = new RequestHandler();
        Thread threadThree = new Thread(requestHandlerThree);

        RequestHandler requestHandlerFour = new RequestHandler();
        Thread threadFour = new Thread(requestHandlerFour);

        RequestHandler requestHandlerFive = new RequestHandler();
        Thread threadFive = new Thread(requestHandlerFive);

        RequestHandler requestHandlerSix = new RequestHandler();
        Thread threadSix = new Thread(requestHandlerSix);

        RequestHandler requestHandlerSeven = new RequestHandler();
        Thread threadSeven = new Thread(requestHandlerSeven);

        RequestHandler requestHandlerEight = new RequestHandler();
        Thread threadEight = new Thread(requestHandlerEight);

        RequestHandler requestHandlerNine = new RequestHandler();
        Thread threadNine = new Thread(requestHandlerNine);

        RequestHandler requestHandlerTen = new RequestHandler();
        Thread threadTen = new Thread(requestHandlerTen);

        RequestHandler requestHandlerEleven = new RequestHandler();
        Thread threadEleven = new Thread(requestHandlerEleven);

        RequestHandler requestHandlerTwelve = new RequestHandler();
        Thread threadTwelve = new Thread(requestHandlerTwelve);

        RequestHandler requestHandlerThirteen = new RequestHandler();
        Thread threadThirteen = new Thread(requestHandlerThirteen);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();
        threadSix.start();
        threadSeven.start();
        threadEight.start();
        threadNine.start();
        threadTen.start();
        threadEleven.start();
        threadTwelve.start();
        threadThirteen.start();

        requestHandlerOne.setDone();
        requestHandlerTwo.setDone();
        requestHandlerThree.setDone();
        requestHandlerFour.setDone();
        requestHandlerFive.setDone();
        requestHandlerSix.setDone();
        requestHandlerSeven.setDone();
        requestHandlerEight.setDone();
        requestHandlerNine.setDone();
        requestHandlerTen.setDone();
        requestHandlerEleven.setDone();
        requestHandlerTwelve.setDone();
        requestHandlerThirteen.setDone();

        threadOne.interrupt();
        threadTwo.interrupt();
        threadThree.interrupt();
        threadFour.interrupt();
        threadFive.interrupt();
        threadSix.interrupt();
        threadSeven.interrupt();
        threadEight.interrupt();
        threadNine.interrupt();
        threadTen.interrupt();
        threadEleven.interrupt();
        threadTwelve.interrupt();
        threadThirteen.interrupt();

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
            threadFive.join();
            threadSix.join();
            threadSeven.join();
            threadEight.join();
            threadNine.join();
            threadTen.join();
            threadEleven.join();
            threadTwelve.join();
            threadThirteen.join();
        } catch (InterruptedException exception) {
            System.out.println(exception);
        }

    }
}
