package AD.SW01;

public class ZeichnungsProgramm {

    private static int counter = 10;

    public static void main(String[] args){
        colorArea(5,5);
    }

    public static void colorArea(final int x, final int y){
        if(counter != 0){
            counter--;
            System.out.println(counter);
            System.out.println("Pixel xy gefärbt");
            System.out.println("rechts");
            colorArea(x+1,y);
            System.out.println("oben");
            colorArea(x,y+1);
            System.out.println("links");
            colorArea(x-1,y);
            System.out.println("unten");
            colorArea(x, y-1);

        }
    }
}
