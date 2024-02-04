package org.example;

import java.util.Comparator;

/**
 * Утилитарный класс CustomArrayListUtils предоставляет статические методы
 * для сортировки элементов в CustomArrayList с использованием алгоритма быстрой сортировки.
 */
public class CustomArrayListUtils {

    /**
     * Сортирует элементы в CustomArrayList с использованием алгоритма быстрой сортировки.
     */
    public static <E> void quickSort(CustomArrayList<E> list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.size() - 1, comparator);
    }

    /**
     * Рекурсивный вспомогательный метод для быстрой сортировки.
     */
    private static <E> void quickSort(CustomArrayList<E> list, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int partitionIndex = partition(list, low, high, comparator);

            quickSort(list, low, partitionIndex - 1, comparator);
            quickSort(list, partitionIndex + 1, high, comparator);
        }
    }

    /**
     * Вспомогательный метод для разделения массива при быстрой сортировке.
     *
     * @return Индекс опорного элемента после разделения.
     */
    private static <E> int partition(CustomArrayList<E> list, int low, int high, Comparator<? super E> comparator) {
        E pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Вспомогательный метод для обмена двух элементов в CustomArrayList.
     */
    private static <E> void swap(CustomArrayList<E> list, int i, int j) {
        E temp = list.get(i);
        list.add(i, list.get(j));
        list.add(j, temp);
    }
}

