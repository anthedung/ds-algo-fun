package stack_queue;

import junit.framework.TestCase;
import org.junit.Test;
import queue_stack.RandomizedQueue;

import java.util.Iterator;

public class RandomizedQueueTest extends TestCase {

    @Test
    public void testRandomizedQueueIt() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();

        q.enqueue(10);
        q.enqueue(12);
        q.enqueue(14);
        q.enqueue(17);

        Iterator<Integer> it = q.iterator();
        assertEquals(new Integer(10), it.next());
        assertEquals(new Integer(12), it.next());
        assertEquals(new Integer(14), it.next());
        assertEquals(new Integer(17), it.next());
    }
}
