import org.ek.ParallelMaximizer;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ParallelMaximizerTest {

    ParallelMaximizer parallelMaximizer;

    @Test
    public void testSerialAndParallel() {
        int size = 1000000; // size of list
        List<Integer> list = new LinkedList<>();
        Random rand = new Random();
        // populate list with random elements
        for (int i=0; i<size; i++) {
            int next = rand.nextInt();
            list.add(next);
        }
        int serialMax = Integer.MIN_VALUE;
        int parallelMax = Integer.MIN_VALUE;

        long startTime = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            serialMax = Math.max(serialMax, list.get(i)); // compute serialMax
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Serial Max: "+serialMax + " computed in: "+(endTime-startTime)+"ms");

        try {
            startTime = System.currentTimeMillis();
            parallelMaximizer = new ParallelMaximizer(list);
            parallelMax = parallelMaximizer.getMax();
            endTime = System.currentTimeMillis();
            System.out.println("Parallel Max: "+ parallelMax + " computed in: "+ (endTime-startTime)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("The serial max doesn't match the parallel max", serialMax, parallelMax);
    }
}
