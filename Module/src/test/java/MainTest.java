import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testConstructor() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3}, 3);
        assertEquals(3, list.length());
    }

    @Test
    void testEmpty() {
        DynamicArray any = new DynamicArray(new int[0], 0);
        DynamicArray list = any.empty();
        assertEquals(0, list.length());
    }

    @Test
    void testGet() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3}, 3);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(2));
    }

    @Test
    void testSet() {
        DynamicArray list = new DynamicArray(new int[]{1, 2, 3}, 3);
        list.set(1, 5);
        assertEquals(5, list.get(1));
    }

    @Test
    void testEquals() {
        DynamicArray a = new DynamicArray(new int[]{1, 2, 3}, 3);
        DynamicArray b = new DynamicArray(new int[]{1, 2, 3}, 3);
        assertTrue(a.equals(b));
        DynamicArray c = new DynamicArray(new int[]{1, 2, 3}, 3);
        DynamicArray d = new DynamicArray(new int[]{1, 2, 4}, 3);
        assertFalse(c.equals(d));
    }

    @Test
    void testEqualElts() {
        DynamicArray a = new DynamicArray(new int[]{5, 6, 7}, 3);
        DynamicArray b = new DynamicArray(new int[]{5, 6, 7, 0}, 3);
        DynamicArray c = new DynamicArray(new int[]{5,7,8,0}, 3);
        assertTrue(a.equalElts(b));
        assertFalse(a.equalElts(c));
    }

    @Test
    void testAddToEnd() {
        // backing array capacity 2, already full
        DynamicArray a = new DynamicArray(new int[]{1, 2}, 2);
        a.addToEnd(3);
        assertEquals(3, a.length());
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(3, a.get(2));
    }

    @Test
    void testAddToStart() {
        DynamicArray a = new DynamicArray(new int[]{2, 3, 0}, 2);
        a.addToStart(1);
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(3, a.get(2));
    }

    @Test
    void testInsert() {
        DynamicArray a = new DynamicArray(new int[]{1, 2, 4, 0}, 3);
        a.insert(2, 3);
        assertEquals(3, a.get(2));
        assertEquals(4, a.get(3));
    }

    @Test
    void testRemove() {
        DynamicArray a = new DynamicArray(new int[]{1, 2, 3, 4, 5}, 5);
        a.remove(2);
        assertEquals(4, a.length());
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(4, a.get(2));
        assertEquals(5, a.get(3));
    }

}
