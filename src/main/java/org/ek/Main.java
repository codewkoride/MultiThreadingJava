package org.ek;


public class Main {
    public static void main(String[] args) {
        try {
            ParallelMaximizer parallelMaximizer = new ParallelMaximizer();
            int maxNumber = parallelMaximizer.getMax();
            System.out.println("Max number when run in parallel is : " + maxNumber);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}