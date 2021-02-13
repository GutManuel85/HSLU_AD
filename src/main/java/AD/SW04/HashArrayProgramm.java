package AD.SW04;

public class HashArrayProgramm {

    public static void main(String[] args){
        HashArrayImplementation hashArray1 = new HashArrayImplementation();
        System.out.println("The length of array is " + hashArray1.getSize());
        hashArray1.add(-1);
        hashArray1.add(0);
        hashArray1.add(1);
        hashArray1.add(2);
        hashArray1.add(10);
        hashArray1.remove(-1);
        hashArray1.remove(0);
        hashArray1.remove(1);
        hashArray1.remove(2);
        hashArray1.remove(10);
        hashArray1.toString();
    }
}
