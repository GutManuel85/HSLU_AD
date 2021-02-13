package ch.hslu.demo.EqualsHashcodeComparable;

public class PersonMain {

    public static void main(String[] args) {

        PersonenVerzeichnis personenVerzeichnis1 = generatePersonenVerzeichnisWithPersons();

        Person person1 = new Person(0,"A", "A");

        //personenVerzeichnis1.addPerson(person1);

        printGeneratedPersons(personenVerzeichnis1);

        personenVerzeichnis1.sortReverse();

        System.out.println();

        printGeneratedPersons(personenVerzeichnis1);

        System.out.println("Person ist enthalten: " + personenVerzeichnis1.getVerzeichnis().contains(person1));
    }

    public static PersonenVerzeichnis generatePersonenVerzeichnisWithPersons() {
        PersonenVerzeichnis personenVerzeichnis = new PersonenVerzeichnis();
        for (int i = 5; i > 0; i--) {
            Person person = new Person("A", "A");
            personenVerzeichnis.addPerson(person);
        }
        return personenVerzeichnis;
    }


    public static void printGeneratedPersons(PersonenVerzeichnis personenVerzeichnis) {
        personenVerzeichnis.printVerzeichnis();

    }
}
