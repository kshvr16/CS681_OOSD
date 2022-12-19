package edu.umb.cs681.admissionmonitor;

public class MainHandler {
    public static void main(String[] args) {
        AdmissionMonitor admissionMonitor = new AdmissionMonitor();

//        Entrance Handler instances and threads
        EntranceHandler entranceHandlerOne = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerOne = new Thread(entranceHandlerOne);

        EntranceHandler entranceHandlerTwo = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerTwo = new Thread(entranceHandlerTwo);

        EntranceHandler entranceHandlerThree = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerThree = new Thread(entranceHandlerThree);

        EntranceHandler entranceHandlerFour = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerFour = new Thread(entranceHandlerFour);

        EntranceHandler entranceHandlerFive = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerFive = new Thread(entranceHandlerFive);

        EntranceHandler entranceHandlerSix = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerSix = new Thread(entranceHandlerSix);

        EntranceHandler entranceHandlerSeven = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerSeven = new Thread(entranceHandlerSeven);

        EntranceHandler entranceHandlerEight = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerEight = new Thread(entranceHandlerEight);

        EntranceHandler entranceHandlerNine = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerNine = new Thread(entranceHandlerNine);

        EntranceHandler entranceHandlerTen = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerTen = new Thread(entranceHandlerTen);

        EntranceHandler entranceHandlerEleven = new EntranceHandler(admissionMonitor);
        Thread threadEntranceHandlerEleven = new Thread(entranceHandlerEleven);

//        Exit handler instances and threads
        ExitHandler exitHandlerOne = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerOne = new Thread(exitHandlerOne);

        ExitHandler exitHandlerTwo = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerTwo = new Thread(exitHandlerTwo);

        ExitHandler exitHandlerThree = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerThree = new Thread(exitHandlerThree);

        ExitHandler exitHandlerFour = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerFour = new Thread(exitHandlerFour);

        ExitHandler exitHandlerFive = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerFive = new Thread(exitHandlerFive);

        ExitHandler exitHandlerSix = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerSix = new Thread(exitHandlerSix);

        ExitHandler exitHandlerSeven = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerSeven = new Thread(exitHandlerSeven);

        ExitHandler exitHandlerEight = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerEight = new Thread(exitHandlerEight);

        ExitHandler exitHandlerNine = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerNine = new Thread(exitHandlerNine);

        ExitHandler exitHandlerTen = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerTen = new Thread(exitHandlerTen);

        ExitHandler exitHandlerEleven = new ExitHandler(admissionMonitor);
        Thread threadExitHandlerEleven = new Thread(exitHandlerEleven);

//        Stats handler instances and threads
        StatsHandler statsHandlerOne = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerOne = new Thread(statsHandlerOne);

        StatsHandler statsHandlerTwo = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerTwo = new Thread(statsHandlerTwo);

        StatsHandler statsHandlerThree = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerThree = new Thread(statsHandlerThree);

        StatsHandler statsHandlerFour = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerFour = new Thread(statsHandlerFour);

        StatsHandler statsHandlerFive = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerFive = new Thread(statsHandlerFive);

        StatsHandler statsHandlerSix = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerSix = new Thread(statsHandlerSix);

        StatsHandler statsHandlerSeven = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerSeven = new Thread(statsHandlerSeven);

        StatsHandler statsHandlerEight = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerEight = new Thread(statsHandlerEight);

        StatsHandler statsHandlerNine = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerNine = new Thread(statsHandlerNine);

        StatsHandler statsHandlerTen = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerTen = new Thread(statsHandlerTen);

        StatsHandler statsHandlerEleven = new StatsHandler(admissionMonitor);
        Thread threadStatsHandlerEleven = new Thread(statsHandlerEleven);

        threadEntranceHandlerOne.start();
        threadEntranceHandlerTwo.start();
        threadEntranceHandlerThree.start();
        threadEntranceHandlerFour.start();
        threadEntranceHandlerFive.start();
        threadEntranceHandlerSix.start();
        threadEntranceHandlerSeven.start();
        threadEntranceHandlerEight.start();
        threadEntranceHandlerNine.start();
        threadEntranceHandlerTen.start();
        threadEntranceHandlerEleven.start();

        threadExitHandlerOne.start();
        threadStatsHandlerOne.start();
        threadExitHandlerTwo.start();
        threadStatsHandlerTwo.start();
        threadExitHandlerThree.start();
        threadStatsHandlerThree.start();
        threadExitHandlerFour.start();
        threadStatsHandlerFour.start();
        threadExitHandlerFive.start();
        threadStatsHandlerFive.start();
        threadExitHandlerSix.start();
        threadStatsHandlerSix.start();
        threadExitHandlerSeven.start();
        threadStatsHandlerSeven.start();
        threadExitHandlerEight.start();
        threadStatsHandlerEight.start();
        threadExitHandlerNine.start();
        threadStatsHandlerNine.start();
        threadExitHandlerTen.start();
        threadStatsHandlerTen.start();
        threadExitHandlerEleven.start();
        threadStatsHandlerEleven.start();

        entranceHandlerOne.setDone();
        entranceHandlerTwo.setDone();
        entranceHandlerThree.setDone();
        entranceHandlerFour.setDone();
        entranceHandlerFive.setDone();
        entranceHandlerSix.setDone();
        entranceHandlerSeven.setDone();
        entranceHandlerEight.setDone();
        entranceHandlerNine.setDone();
        entranceHandlerTen.setDone();
        entranceHandlerEleven.setDone();

        exitHandlerOne.setDone();
        exitHandlerTwo.setDone();
        exitHandlerThree.setDone();
        exitHandlerFour.setDone();
        exitHandlerFive.setDone();
        exitHandlerSix.setDone();
        exitHandlerSeven.setDone();
        exitHandlerEight.setDone();
        exitHandlerNine.setDone();
        exitHandlerTen.setDone();
        exitHandlerEleven.setDone();

        statsHandlerOne.setDone();
        statsHandlerTwo.setDone();
        statsHandlerThree.setDone();
        statsHandlerFour.setDone();
        statsHandlerFive.setDone();
        statsHandlerSix.setDone();
        statsHandlerSeven.setDone();
        statsHandlerEight.setDone();
        statsHandlerNine.setDone();
        statsHandlerTen.setDone();
        statsHandlerEleven.setDone();

        threadEntranceHandlerOne.interrupt();
        threadEntranceHandlerTwo.interrupt();
        threadEntranceHandlerThree.interrupt();
        threadEntranceHandlerFour.interrupt();
        threadEntranceHandlerFive.interrupt();
        threadEntranceHandlerSix.interrupt();
        threadEntranceHandlerSeven.interrupt();
        threadEntranceHandlerEight.interrupt();
        threadEntranceHandlerNine.interrupt();
        threadEntranceHandlerTen.interrupt();
        threadEntranceHandlerEleven.interrupt();

        threadExitHandlerOne.interrupt();
        threadExitHandlerTwo.interrupt();
        threadExitHandlerThree.interrupt();
        threadExitHandlerFour.interrupt();
        threadExitHandlerFive.interrupt();
        threadExitHandlerSix.interrupt();
        threadExitHandlerSeven.interrupt();
        threadExitHandlerEight.interrupt();
        threadExitHandlerNine.interrupt();
        threadExitHandlerTen.interrupt();
        threadExitHandlerEleven.interrupt();

        threadStatsHandlerOne.interrupt();
        threadStatsHandlerTwo.interrupt();
        threadStatsHandlerThree.interrupt();
        threadStatsHandlerFour.interrupt();
        threadStatsHandlerFive.interrupt();
        threadStatsHandlerSix.interrupt();
        threadStatsHandlerSeven.interrupt();
        threadStatsHandlerEight.interrupt();
        threadStatsHandlerNine.interrupt();
        threadStatsHandlerTen.interrupt();
        threadStatsHandlerEleven.interrupt();

        try {
            threadEntranceHandlerOne.join();
            threadEntranceHandlerTwo.join();
            threadEntranceHandlerThree.join();
            threadEntranceHandlerFour.join();
            threadEntranceHandlerFive.join();
            threadEntranceHandlerSix.join();
            threadEntranceHandlerSeven.join();
            threadEntranceHandlerEight.join();
            threadEntranceHandlerNine.join();
            threadEntranceHandlerTen.join();
            threadEntranceHandlerEleven.join();

            threadExitHandlerOne.join();
            threadExitHandlerTwo.join();
            threadExitHandlerThree.join();
            threadExitHandlerFour.join();
            threadExitHandlerFive.join();
            threadExitHandlerSix.join();
            threadExitHandlerSeven.join();
            threadExitHandlerEight.join();
            threadExitHandlerNine.join();
            threadExitHandlerTen.join();
            threadExitHandlerEleven.join();

            threadStatsHandlerOne.join();
            threadStatsHandlerTwo.join();
            threadStatsHandlerThree.join();
            threadStatsHandlerFour.join();
            threadStatsHandlerFive.join();
            threadStatsHandlerSix.join();
            threadStatsHandlerSeven.join();
            threadStatsHandlerEight.join();
            threadStatsHandlerNine.join();
            threadStatsHandlerTen.join();
            threadStatsHandlerEleven.join();
        } catch(InterruptedException exception) {
            System.out.println(exception);
        }

    }
}
