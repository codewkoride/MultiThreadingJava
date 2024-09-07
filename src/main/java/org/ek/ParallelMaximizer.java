package org.ek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class ParallelMaximizer {
    int parallelWorkers = 2000;
    int size = 10000000;
    List<ParallelWorker> workers = new ArrayList<>(parallelWorkers);
    List<Integer> list = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(ParallelMaximizer.class.getName());

    public ParallelMaximizer() {
        //Create a random list of integers
        Random random = new Random();
        for (int i=0; i<size; i++) {
            list.add(random.nextInt());
        }
    }
    public ParallelMaximizer(List<Integer> list) {
        this.list = list;
    }
    public int getMax() throws InterruptedException {
        //LOGGER.info("Random List is created with size : "+ size);
        //Now create required parallel workers and start this execution on a new thread for each worker
        for (int i=0; i<parallelWorkers; i++){
            workers.add(i, new ParallelWorker(list));
            workers.get(i).start();
        }
        LOGGER.info(parallelWorkers + " threads are created and execution in progress");

        //Initialize result
        int result = Integer.MIN_VALUE;

        //How do you know threads have finished execution?
        for (int i=0; i<parallelWorkers; i++) {
            workers.get(i).join();
        }

        LOGGER.info("Threads execution completed");

        //Once threads execution is finished, compute the maximum
        for (int i=0; i<parallelWorkers; i++) {
            if (workers.get(i).getPartialMax() > result) {
                result = workers.get(i).getPartialMax();
            }
        }

        return result;
    }
}
