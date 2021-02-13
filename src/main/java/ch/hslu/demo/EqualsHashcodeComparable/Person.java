package ch.hslu.demo.EqualsHashcodeComparable;

public class Person implements Comparable<Person> {


    public static int personenCounter = 0;

    private int id;
    private String name;
    private String vorname;


    public Person(String name, String vorname) {
        this.id = personenCounter++;
        this.name = name;
        this.vorname = vorname;
    }

    public Person(int id, String name, String vorname){
        this(name, vorname);
        this.id = id;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.valueOf(id) + " / " + name + " / " + vorname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        return (this.id == other.id);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
