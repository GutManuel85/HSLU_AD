package ch.hslu.demo.CollectionEinsatz;

import java.util.HashSet;
import java.util.Set;

public class CollectionSetMain {

    public static void main(String[] args) {

        final Set<Person> personSet = new HashSet<>();

        personSet.add(new Person("Hans1", "Muster1"));
        personSet.add(new Person("Hans2", "Muster2"));
        personSet.add(new Person("Hans3", "Muster3"));

        System.out.println(personSet.size());

        personSet.add(new Person("Hans1", "Muster1"));

        System.out.println(personSet.size());

        personSet.add(new Person(3,"Hans1", "Muster1" ));

        System.out.println(personSet.size() + "Person wurde nicht eingefügt, da es gemäss equals-Definition auf" +
                "Klasse Person bereits eine gleiche Person gibt, da diese auch die id == 3 hat.");

    }
}
