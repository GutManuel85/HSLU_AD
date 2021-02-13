package AD.SW10;

import AD.SW10.Triangle.TriangleSpezielleOrdnung;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSpezielleOrdnungTest {


    @Test
    void testGetHighestPoint() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(1, 1, 2, 4, 3, 1);
        assertEquals(2, triangleSpezielleOrdnung1.getHighestPoint());
        assertEquals(4, triangleSpezielleOrdnung2.getHighestPoint());

    }

    @Test
    void testCompareToGleicherUmfangGleicherHighestPoint() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 1, 3, 2, 4, 1);
        assertEquals(0, triangleSpezielleOrdnung1.compareTo(triangleSpezielleOrdnung2));
    }

    @Test
    void testCompareToNurGleicherUmfang() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 2, 3, 3, 4, 2);
        assertEquals(triangleSpezielleOrdnung1.getUmfang(), triangleSpezielleOrdnung2.getUmfang());
        assertNotEquals(0, triangleSpezielleOrdnung1.compareTo(triangleSpezielleOrdnung2));
    }

    @Test
    void testEqualsGleicherUmfangGleicherHighestPoint() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 1, 3, 2, 4, 1);
        assertEquals(triangleSpezielleOrdnung1, triangleSpezielleOrdnung2);
    }

    @Test
    void testEqualsNurGleicherUmfang() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 2, 3, 3, 4, 2);
        assertEquals(triangleSpezielleOrdnung1.getUmfang(), triangleSpezielleOrdnung2.getUmfang());
        assertNotEquals(false, triangleSpezielleOrdnung1.compareTo(triangleSpezielleOrdnung2));
    }

    @Test
    void testHashCodeUmfangGleicherHighestPoint() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 1, 3, 2, 4, 1);
        assertEquals(triangleSpezielleOrdnung1, triangleSpezielleOrdnung2);
    }

    @Test
    void testHashCodeToNurGleicherUmfang() {
        TriangleSpezielleOrdnung triangleSpezielleOrdnung1 = new TriangleSpezielleOrdnung(1, 1, 2, 2, 3, 1);
        TriangleSpezielleOrdnung triangleSpezielleOrdnung2 = new TriangleSpezielleOrdnung(2, 2, 3, 3, 4, 2);
        assertEquals(triangleSpezielleOrdnung1.getUmfang(), triangleSpezielleOrdnung2.getUmfang());
        assertFalse(triangleSpezielleOrdnung1.hashCode() == triangleSpezielleOrdnung2.hashCode());
    }
}