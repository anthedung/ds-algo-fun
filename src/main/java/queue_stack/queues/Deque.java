import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    // Node of Deque
    private class Node {
        Node next;
        Node prev;
        Item item;

        Node(Item i) {
            item = i;
        }
    }

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        size++;

        Node newHead = new Node(item);

        if (head == null) {
            head = newHead;
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        size++;

        Node newTail = new Node(item);

        if (tail == null) {
            head = newTail;
            tail = newTail;
        } else {
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node toRemove = head;

        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        } else if (size == 1) {
            head = head.next;
            tail.prev = null; // since now tail == head
        } else {
            head = head.next;
        }

        return toRemove.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node toRemove = tail;

        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        } else if (size == 1) {
            tail = tail.prev;
            head.next = null; // since now tail == head
        } else {
            tail = tail.prev;
        }

        return toRemove.item;
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node temp = current;
                current = current.next;
                return temp.item;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }
}
