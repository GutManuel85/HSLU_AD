package AD.SW02.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testKonstruktor(){
        Stack stack = new Stack(10);
        assertEquals(10,stack.getStringArray().length);
    }

    @Test
    void testKonstruktorArrayIsEmptyAfterCreating(){
        Stack stack = new Stack(10);
        assertEquals(null, stack.getStringArray()[0]);
    }

    @Test
    void testPushNotEmpty(){
        Stack stack = new Stack(10);
        stack.push("HalloWelt");
        assertTrue(stack.getStringArray()[0] != null);
    }

    @Test
    void testStackOneFullAfterPush(){
        Stack stack = new Stack(1);
        stack.push("HalloWelt");
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{stack.push("EinStringZuviel");});
    }

    @Test
    void testPop(){
        Stack stack = new Stack(1);
        stack.push("PopString");
        assertEquals("PopString", stack.pop());
    }

    @Test
    void testPopWhileStackIsEmpty() {
        Stack stack = new Stack(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{stack.pop();});
    }
}