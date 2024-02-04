package org.example;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArrayListUtilsTest {

    @Test
    void testQuickSort() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(7);

        CustomArrayListUtils.quickSort(list, Comparator.naturalOrder());

        assertEquals(5, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(5), list.get(2));
        assertEquals(Integer.valueOf(7), list.get(3));
        assertEquals(Integer.valueOf(8), list.get(4));
    }

    @Test
    void testQuickSortWithCustomComparator() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("cherry");
        list.add("date");

        Comparator<String> customComparator = (s1, s2) -> s1.length() - s2.length();
        CustomArrayListUtils.quickSort(list, customComparator);

        assertEquals(4, list.size());
        assertEquals("date", list.get(0));
        assertEquals("apple", list.get(1));
        assertEquals("banana", list.get(2));
        assertEquals("cherry", list.get(3));
    }
}
