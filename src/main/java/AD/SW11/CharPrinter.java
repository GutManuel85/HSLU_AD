package AD.SW11;

public class CharPrinter {

    public static void main(String[] args) {

        for(int i = 0; i < 65536; i++)
        System.out.println((char) i);

        System.out.println("Es gibt " + Character.getNumericValue(Character.MAX_CODE_POINT) + " verschiedene Chars");
    }
}
