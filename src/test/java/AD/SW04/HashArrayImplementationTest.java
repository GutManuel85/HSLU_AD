package AD.SW04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HashArrayImplementationTest {

    HashArrayImplementation hashArrayImplementation;

    @BeforeEach
    void setUp() {
        hashArrayImplementation = new HashArrayImplementation();
    }

    @AfterEach
    void tearDown() {
        hashArrayImplementation = null;
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testAdd() {
        hashArrayImplementation.add(4);
        assertEquals(4, hashArrayImplementation.getHashArray()[4].intValue());
    }

    @Test
    void testAddTwice() {
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(4);
        assertEquals(4, hashArrayImplementation.getHashArray()[4].intValue());
        assertThrows(NullPointerException.class, ()->hashArrayImplementation.getHashArray()[5].intValue());
    }

    @Test
    void testAddWithCollision() {
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(5);
        hashArrayImplementation.add(14);
        assertEquals(4, hashArrayImplementation.getHashArray()[4].intValue());
        assertEquals(5, hashArrayImplementation.getHashArray()[5].intValue());
        assertEquals(14, hashArrayImplementation.getHashArray()[6].intValue());
    }

    @Test
    void testAddWithCollisionAndOverflow(){
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(14);
        hashArrayImplementation.add(24);
        hashArrayImplementation.add(34);
        hashArrayImplementation.add(44);
        hashArrayImplementation.add(54);
        hashArrayImplementation.add(64);
        hashArrayImplementation.add(74);
        hashArrayImplementation.add(84);
        hashArrayImplementation.add(94);
        assertEquals(94, hashArrayImplementation.getHashArray()[3].intValue());
        hashArrayImplementation.toString();
    }

    @Test
    void testAddNegativ(){
        hashArrayImplementation.add(-10);
        hashArrayImplementation.add(-9);
        hashArrayImplementation.add(-1);
        assertEquals(-10, hashArrayImplementation.getHashArray()[0].intValue());
        assertEquals(-9, hashArrayImplementation.getHashArray()[1].intValue());
        assertEquals(-1, hashArrayImplementation.getHashArray()[9].intValue());
    }


    @Test
    void testAddNegativWithCollision(){
        hashArrayImplementation.add(-10);
        hashArrayImplementation.add(-9);
        hashArrayImplementation.add(-20);
        assertEquals(-10, hashArrayImplementation.getHashArray()[0].intValue());
        assertEquals(-9, hashArrayImplementation.getHashArray()[1].intValue());
        assertEquals(-20, hashArrayImplementation.getHashArray()[2].intValue());
    }

    @Test
    void testRemove() {
        hashArrayImplementation.add(4);
        hashArrayImplementation.remove(4);
        assertEquals(null, hashArrayImplementation.getHashArray()[4]);
    }

    @Test
    void testSearchFound() {
        hashArrayImplementation.add(0);
        hashArrayImplementation.add(1);
        hashArrayImplementation.add(9);
        assertEquals(1, hashArrayImplementation.search(1));
        assertEquals(9, hashArrayImplementation.search(9));
    }

    @Test
    void testSearchNotFound() {
        hashArrayImplementation.add(0);
        hashArrayImplementation.add(1);
        assertThrows(NoSuchElementException.class, () -> hashArrayImplementation.search(2));
    }

    @Test
    void testGetSize() {
        hashArrayImplementation.add(0);
        hashArrayImplementation.add(1);
        hashArrayImplementation.add(2);
        hashArrayImplementation.add(3);
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(5);
        hashArrayImplementation.add(6);
        hashArrayImplementation.add(7);
        hashArrayImplementation.add(8);
        hashArrayImplementation.add(9);
        assertEquals(10, hashArrayImplementation.getSize());
    }

    @Test
    void testIsFullArrayTrue() {
        hashArrayImplementation.add(0);
        hashArrayImplementation.add(1);
        hashArrayImplementation.add(2);
        hashArrayImplementation.add(3);
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(5);
        hashArrayImplementation.add(6);
        hashArrayImplementation.add(7);
        hashArrayImplementation.add(8);
        hashArrayImplementation.add(9);
        assertEquals(true, hashArrayImplementation.isFullArray());
    }

    @Test
    void testIsFullArrayFalse() {
        hashArrayImplementation.add(0);
        hashArrayImplementation.add(1);
        hashArrayImplementation.add(2);
        hashArrayImplementation.add(3);
        hashArrayImplementation.add(4);
        hashArrayImplementation.add(5);
        hashArrayImplementation.add(6);
        hashArrayImplementation.add(7);
        hashArrayImplementation.add(8);
        assertEquals(false, hashArrayImplementation.isFullArray());
    }

    @Test
    void testMakePositiv(){
        assertEquals(2,hashArrayImplementation.makePositiv(-8));
        assertEquals(8, hashArrayImplementation.makePositiv(-32));
        assertEquals(4, hashArrayImplementation.makePositiv(4));
    }

    @Test
    void testGetIndex(){
        assertEquals(2,hashArrayImplementation.getIndex(-8));
        assertEquals(8, hashArrayImplementation.getIndex(-32));
        assertEquals(0, hashArrayImplementation.getIndex(0));
        assertEquals(4, hashArrayImplementation.getIndex(4));
    }

    @Test
    void testAllreadyExistTrue(){
        hashArrayImplementation.add(2);
        assertEquals(true, hashArrayImplementation.alreadyExisting(2));
    }

    @Test
    void testAllreadyExistFalse(){
        hashArrayImplementation.add(2);
        assertEquals(false, hashArrayImplementation.alreadyExisting(1));
    }

}