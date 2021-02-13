package ch.hslu.demo.CollectionEinsatz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;

public class CollectionDequeMain {

    private static final Logger LOG = LogManager.getLogger(CollectionDequeMain.class);

    public static void main(String [] args){

        LOG.info("Mit den Methoden push() und pop() verhält sich die Deque wie ein Stack -> FILO-Prinzip:");

        Deque<Person> personDequeFILO = new ArrayDeque<>(3);

        personDequeFILO.push(new Person("A","A"));
        personDequeFILO.push(new Person("B", "B"));
        personDequeFILO.push(new Person("C", "C"));

        System.out.println(personDequeFILO.pop());
        System.out.println(personDequeFILO.pop());
        System.out.println(personDequeFILO.pop());

        System.out.println();

        System.out.println("Mit den Methoden offerFirst() und pollLast() verhält sich die Deque wie eine normale Queue");

        Deque<Person> personDequeFIFO = new ArrayDeque<>(3);

        personDequeFIFO.offerFirst(new Person("A","A"));
        personDequeFIFO.offerFirst(new Person("B", "B"));
        personDequeFIFO.offerFirst(new Person("C", "C"));

        System.out.println(personDequeFIFO.pollLast());
        System.out.println(personDequeFIFO.pollLast());
        System.out.println(personDequeFIFO.pollLast());





    }
}
