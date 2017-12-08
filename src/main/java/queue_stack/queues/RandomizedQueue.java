import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] queue;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        // resizing
        if (size == queue.length) {
            // double q len
            Item[] dq = (Item[]) new Object[queue.length * 2];

            for (int i = 0; i < size; i++) {
                dq[i] = queue[i];
            }

            queue = dq;
        }

        queue[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        checkEmpty();

        // resizing
        if (size == queue.length / 4) {
            // double q len
            Item[] dq = (Item[]) new Object[queue.length / 2];

            for (int i = 0; i < size; i++) {
                dq[i] = queue[i];
            }

            queue = dq;
        }

        int rndId = StdRandom.uniform(size);
        Item toDequeue = queue[rndId];
        if (rndId != size - 1) // last one, nothing to do
        {
            // swap between this and the last one, since order doesn't matter
            queue[rndId] = queue[size - 1];
            queue[size - 1] = null; // avoid loitering
        }

        size--;

        return toDequeue;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        checkEmpty();

        int rndId = StdRandom.uniform(size);
        return queue[rndId];
    }

    private void checkEmpty() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    @Override
    public Iterator<Item> iterator() {
        int[] randomIndex = StdRandom.permutation(size);

        return new Iterator<Item>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < size;  // pointer NOT at last elem
            }

            @Override
            public Item next() {
                return queue[randomIndex[pointer++]];
            }
        };
    }
}
