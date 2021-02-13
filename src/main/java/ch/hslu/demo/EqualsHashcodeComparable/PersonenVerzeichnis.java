package ch.hslu.demo.EqualsHashcodeComparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonenVerzeichnis {

    private List<Person> verzeichnis;

    public PersonenVerzeichnis() {
        this.verzeichnis = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        this.verzeichnis.add(person);
    }

    public void printVerzeichnis() {
        for (int i = 0; i < verzeichnis.size(); i++) {
            System.out.println(this.verzeichnis.get(i));
        }
    }

    public Collection getVerzeichnis() {
        return verzeichnis;
    }

    public void sortReverse(){
        Collections.reverse(this.verzeichnis);
    }
}
