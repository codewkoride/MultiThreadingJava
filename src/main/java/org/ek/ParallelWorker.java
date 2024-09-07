package org.ek;

import java.util.List;

public class ParallelWorker extends Thread{
    int partialMax = Integer.MIN_VALUE;
    List<Integer> list;

    public ParallelWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            int nextNumber = Integer.MIN_VALUE;
            //Removing an integer from list has to be in the Synchronized block as it is a Shared Resource
            synchronized (list) {
                //System.out.println(this.getName());
                if (list.isEmpty())
                    return;
                //System.out.println(list.size());
                nextNumber = list.remove(0);
            }
            if (nextNumber > partialMax)
                partialMax = nextNumber;
        }
    }

    public int getPartialMax() {
        return partialMax;
    }
}
