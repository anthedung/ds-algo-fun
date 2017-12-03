package stack_queue;

import junit.framework.TestCase;
import org.junit.Test;
import queue_stack.Deque;

import java.util.Iterator;

public class DequeTest extends TestCase {

    @Test
    public void testDeque() {
        Deque<Integer> d = new Deque<>();

        d.addFirst(10);
        d.addFirst(12);
        d.addFirst(13);
        d.addFirst(15);
        d.addLast(17);

        // 15 13 12 10

        assertEquals(new Integer(15), d.removeFirst());
        assertEquals(new Integer(13), d.removeFirst());
        assertEquals(new Integer(17), d.removeLast());
        assertEquals(new Integer(10), d.removeLast());
    }

    @Test
    public void testIt() {
        Deque<Integer> d = new Deque<>();

        d.addFirst(10);
        d.addFirst(12);
        d.addFirst(13);
        d.addFirst(15);
        d.addLast(17);

        Iterator<Integer> it = d.iterator();
        assertTrue(it.hasNext());

        assertEquals(new Integer(15), it.next());
        assertEquals(new Integer(13), it.next());
        assertEquals(new Integer(12), it.next());
        assertEquals(new Integer(10), it.next());

        assertTrue(it.hasNext());
        assertEquals(new Integer(17), it.next());

        assertFalse(it.hasNext());
    }
}
