package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    private CustomArrayList<Integer> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testAdd() {
        customArrayList.add(1);
        customArrayList.add(2);
        assertEquals(2, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
    }

    @Test
    void testAddAtIndex() { // почитай про конвенции нэймингов тестов
        customArrayList.add(1);
        customArrayList.add(3);
        customArrayList.add(1, 2);
        assertEquals(3, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(2), customArrayList.get(1));
        assertEquals(Integer.valueOf(3), customArrayList.get(2));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(0));
        customArrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(1));
    }

    @Test
    void testRemove() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.remove(Integer.valueOf(2));
        assertEquals(2, customArrayList.size());
        assertEquals(Integer.valueOf(1), customArrayList.get(0));
        assertEquals(Integer.valueOf(3), customArrayList.get(1));
    }


    @Test
    void testClear() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.clear();
        assertEquals(0, customArrayList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(0));
    }

    @Test
    void testEnsureCapacity() {
        for (int i = 0; i < 15; i++) {
            customArrayList.add(i);
        }
        assertEquals(15, customArrayList.size());
    }

    @Test
    void testSize() {
        assertEquals(0, customArrayList.size());
        customArrayList.add(1);
        assertEquals(1, customArrayList.size());
    }
}

