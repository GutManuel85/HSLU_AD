package AD.SW10.Triangle;

import java.util.Arrays;
import java.util.Random;

public class TriangleEditor {

    public static void main(String[] args) {

        TriangleSpezielleOrdnung[] triangles = new TriangleSpezielleOrdnung[100];
        Random random = new Random();
        TriangleComparator comparator = new TriangleComparator();

        for(int i = 0; i < triangles.length; i++){
            triangles[i] = new TriangleSpezielleOrdnung(random.nextInt(10),random.nextInt(10),random.nextInt(10),
                    random.nextInt(10), random.nextInt(10), random.nextInt(10));
        }

        Arrays.sort(triangles,comparator);
        for(TriangleSpezielleOrdnung tso : triangles){
            System.out.println(tso.toString());
        }
    }


}
