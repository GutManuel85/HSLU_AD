package ch.hslu.demo.EqualsHashcodeComparable;

public class GrundstückMain {

    public static void main(String[] args){


        Grundstück grundstück1 = new Grundstück(1000, 1000);
        Grundstück grundstück2 = new Grundstück(1000, 1000);

        GrundstückComparator gsc = new GrundstückComparator();

        System.out.println(gsc.compare(grundstück1, grundstück2));
    }

}
