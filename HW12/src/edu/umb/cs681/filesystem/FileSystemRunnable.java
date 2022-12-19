package edu.umb.cs681.filesystem;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystemRunnable implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;

    // created the file system structure
    LocalDateTime localTime = LocalDateTime.now();
    Directory root = new Directory(null, "root", 0, localTime);
    Directory apps = new Directory(root, "Apps", 0, localTime);
    File x = new File(apps, "x", 10, localTime);
    Directory bin = new Directory(root, "bin", 0, localTime);
    File y = new File(bin, "y", 15, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    Link z = new Link(home, "x", 0, localTime, bin);
    Directory pictures = new Directory(home, "pictures", 0, localTime);
    File a = new File(pictures, "a", 20, localTime);
    File b = new File(pictures, "b", 20, localTime);
    Link cLink = new Link(pictures, "c", 0, localTime, y);
    File c = new File(home, "c", 25, localTime);
    FileSystem fileSystem = FileSystem.getFileSystem();

    private void setDone() {
        this.lock.lock();
        try {
            this.done = true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        this.lock.lock();
        try {
            if(done) {
                System.out.println("The file system runnable is exited!!");
            } else {
                System.out.println("Appending the root directory to the filesystem.");
                fileSystem.appendRootDir(root);
                System.out.println("Children of root: " + root.getChildren());
                System.out.println("Children of apps: " + apps.getChildren());
                System.out.println("Children of bin: " + bin.getChildren());
                System.out.println("Children of home: " + home.getChildren());
                System.out.println("Files present in the apps directory: " + apps.getFiles());
                System.out.println("Files present in the bin directory: " + bin.getFiles());
                System.out.println("Files present in the pictures directory: " + pictures.getFiles());
            }
        } finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] args) {
        FileSystemRunnable fileSystemRunnable = new FileSystemRunnable();
        Thread threadOne = new Thread(fileSystemRunnable);
        Thread threadTwo = new Thread(fileSystemRunnable);
        Thread threadThree = new Thread(fileSystemRunnable);
        Thread threadFour = new Thread(fileSystemRunnable);
        Thread threadFive = new Thread(fileSystemRunnable);
        Thread threadSix = new Thread(fileSystemRunnable);
        Thread threadSeven = new Thread(fileSystemRunnable);
        Thread threadEight = new Thread(fileSystemRunnable);
        Thread threadNine = new Thread(fileSystemRunnable);
        Thread threadTen = new Thread(fileSystemRunnable);
        Thread threadEleven = new Thread(fileSystemRunnable);
        Thread threadTwelve = new Thread(fileSystemRunnable);

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

        fileSystemRunnable.setDone();

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
        } catch(InterruptedException exception) {
            System.out.println(exception);
        }
    }
}
