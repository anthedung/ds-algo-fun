package memoization;

import dynamic_programming.memoization.Fibonacci;
import junit.framework.TestCase;
import org.junit.Test;

public class FibonacciTest extends TestCase {

    @Test
    public void testSlowFib() {
        // idx: 1,2,3,4,5
        // val: 1,1,2,3,5
        assertEquals(13, new Fibonacci().slowFib(7));
    }

    @Test
    public void testMemoizeFib() {
        // idx: 1,2,3,4,5
        // val: 1,1,2,3,5
        assertEquals(13, new Fibonacci().memoizeFib(7));
    }

    @Test
    public void testXYFib() {
        // idx: 1,2,3,4,5
        // val: 1,1,2,3,5
        assertEquals(13, new Fibonacci().xyFib(7));
    }


    @Test
    public void testCallCountReduce() {
        Fibonacci slow = new Fibonacci();
        slow.slowFib(7);

        Fibonacci memoize = new Fibonacci();
        memoize.memoizeFib(7);

        // calls reduced
        System.out.println(memoize.getFnCallCount());
        System.out.println(slow.getFnCallCount());

        // a lot fewer calls with the memoize technique
        assertTrue(memoize.getFnCallCount() * 3 < slow.getFnCallCount());
    }


}
