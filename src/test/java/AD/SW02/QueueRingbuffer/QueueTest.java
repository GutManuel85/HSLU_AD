package AD.SW02.QueueRingbuffer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue queue = new Queue();
        queue.enqueue('a');
        assertEquals('a', queue.getArray()[0]);
    }

    @Test
    void deque() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue('b');
        assertEquals('a', queue.deque());
        assertEquals('b', queue.deque());
    }

    @Test
    void dequeWithEmptyQueue() {
        Queue queue = new Queue();
        assertThrows(NullPointerException.class, () -> {
            queue.deque();
        });
    }

    @Test
    void uebertritt() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.deque(); //a
        queue.deque();//b
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h'); // hier geschieht der Übertritt auf 8Modulo8 = 0
        queue.enqueue('i');
        queue.deque(); //c
        queue.deque(); //d
        queue.deque(); //e
        queue.deque(); //f
        queue.deque(); //g
        queue.deque(); //h
        assertEquals('i', queue.deque());
    }

    @Test
    void enqueueWithFullQueue() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h'); // hier ist die Queue voll
        assertFalse(queue.enqueue('i'));
    }

    @Test
    void testToString() {
        Queue queue = new Queue();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h');
        queue.deque();
        queue.enqueue('i');

        assertEquals("Die Queue hat " + queue.getAnzahlElemente() +
                " Elemente. Dies sind die folgenden: bcdefghi", queue.toString());
    }
}