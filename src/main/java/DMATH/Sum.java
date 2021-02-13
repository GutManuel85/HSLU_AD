package DMATH;

public class Sum {

    public static void main(String[] args){
        math2();
        }

    public static void math1() {
        double sum = 1;
        for (int k = 5; k <= 8; k++) {
            System.out.println(sum *= Math.pow(Math.E, (-k)));
        }
    }

    public static void math2(){
        double sum = 1;
        for(int i = 1; i<=100; i++){
            System.out.println(sum *= Math.pow(-2,i));
        }
    }
}
