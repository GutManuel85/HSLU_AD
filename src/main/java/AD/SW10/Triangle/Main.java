package AD.SW10.Triangle;

public class Main {

    public static void main(String[] args) {

        Triangle triangle1 = new Triangle(1,1,2,2,4,1);
        Triangle triangle2 = new Triangle(1,1,2,2,4,1);

        System.out.println("Umfang ist: " + triangle1.getUmfang());
        System.out.println("Umfang ist: " + triangle2.getUmfang());
        System.out.println(triangle1.compareTo(triangle2));
        System.out.println(triangle1.hashCode());
        System.out.println(triangle2.hashCode());
    }
}
