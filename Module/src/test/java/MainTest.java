import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testConstructorAndLength() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3}, 3);
        assertEquals(3, list.length());
    }

    @Test
    void testEmpty() {
        // empty() is an instance method, so it needs an object to call it on
        DynamicArray any = new DynamicArray(new int[0], 0);
        DynamicArray list = any.empty();
        assertEquals(0, list.length());
    }

    @Test
    void testGet() {
        DynamicArray list = new DynamicArray(new int[]{10, 20, 30}, 3);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));
    }

    @Test
    void testSet() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3}, 3);
        list.set(1, 99);
        assertEquals(99, list.get(1));
        assertEquals(3, list.length()); // set must not change length
    }

    @Test
    void testEqualsSameContents() {
        DynamicArray a = new DynamicArray(new int[]{1, 2, 3}, 3);
        DynamicArray b = new DynamicArray(new int[]{1, 2, 3}, 3);
        assertTrue(a.equals(b));
    }

    @Test
    void testEqualsDifferentContents() {
        DynamicArray a = new DynamicArray(new int[]{1, 2, 3}, 3);
        DynamicArray b = new DynamicArray(new int[]{1, 2, 4}, 3);
        assertFalse(a.equals(b));
    }

    @Test
    void testEqualEltsSameElementsDifferentBackingArray() {
        // one array sized exactly right, the other with spare capacity
        DynamicArray tight = new DynamicArray(new int[]{5, 6, 7}, 3);
        DynamicArray loose = new DynamicArray(new int[]{5, 6, 7, 0}, 3);
        assertTrue(tight.equalElts(loose));
        assertFalse(tight.equals(loose)); // equals cares about the array itself
    }

    @Test
    void testAddToEndTriggersDoubling() {
        // backing array capacity 2, already full
        DynamicArray list = new DynamicArray(new int[]{1, 2}, 2);
        list.addToEnd(3);
        assertEquals(3, list.length());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddToStart() {
        DynamicArray list = new DynamicArray(new int[]{2, 3, 0}, 2);
        list.addToStart(1);
        assertEquals(3, list.length());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testInsertMiddle() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 4, 5, 0}, 4);
        list.insert(2, 3);
        assertEquals(5, list.length());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void testRemoveMiddle() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3, 4, 5}, 5);
        list.remove(2); // removes the 3
        assertEquals(4, list.length());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));
    }

}
