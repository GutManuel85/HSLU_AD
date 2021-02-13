package ch.hslu.demo.CollectionEinsatz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionListMain {

    public static void main(String[] args){

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("A", "A"));
        personList.add(new Person("B", "B"));
        personList.add(new Person("C", "C"));

        Iterator iterator1 = personList.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        personList.set(2, new Person("X", "X"));

        System.out.println();

        Iterator iterator2 = personList.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }


    }
}
