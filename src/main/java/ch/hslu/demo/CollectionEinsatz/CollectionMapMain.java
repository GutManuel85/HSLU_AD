package ch.hslu.demo.CollectionEinsatz;

import java.util.HashMap;
import java.util.Map;

public class CollectionMapMain {

    public static void main(String [] args){

        Map<String, Person> personMap = new HashMap<>();

        personMap.put("Key1",new Person("A", "A"));
        personMap.put("Key2", new Person("B", "B"));
        personMap.put("Key3", new Person("C", "C"));

        personMap.put("Key1", new Person("Changed", "Changed"));

        System.out.println(personMap.get("Key1").toString());
    }
}
