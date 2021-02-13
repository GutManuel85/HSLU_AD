package ch.hslu.demo.CollectionEinsatz;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionQueueMain {

    public static int queueCounter = 0;

    public static void main(String[] args) {

        Queue<Person> personQueue = new ArrayBlockingQueue<>(5);


        personQueue.offer(addPersonToQueue(new Person("A", "A")));
        personQueue.offer(addPersonToQueue(new Person("B", "B")));
        personQueue.offer(addPersonToQueue(new Person("C", "C")));
        personQueue.offer(addPersonToQueue(new Person("D", "D")));
        personQueue.offer(addPersonToQueue(new Person("E", "E")));

        Iterator<Person> personIterator1 = personQueue.iterator();
        for (Person person : personQueue) {
            System.out.println(personIterator1.next());
        }

        System.out.println();

        for (int i = 0; i < queueCounter; i++) {
            System.out.println(personQueue.poll());
        }

    }

    public static Person addPersonToQueue(Person person){
        queueCounter++;
                return person;
    }

}
