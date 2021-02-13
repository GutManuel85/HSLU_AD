package AD.SW02.QueueRingbuffer;

import AD.SW02.QueueRingbuffer.Queue;

public class QueueProgramm {

    public static void main(String[] args){

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

        System.out.println(queue.toString());

    }
}
