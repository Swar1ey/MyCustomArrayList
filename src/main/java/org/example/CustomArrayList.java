package org.example;

import java.util.Arrays;

/**
 * Класс CustomArrayList представляет собой реализацию динамического массива.
 * Этот класс предоставляет основные операции добавления, получения, удаления
 * элементов и другие методы для управления массивом.
 *
 * @param <E> Тип элементов, которые могут быть добавлены в список.
 */
public class CustomArrayList<E> {
    /**
     * Константа, представляющая размер массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив для хранения элементов списка.
     */
    private Object[] elements;

    /**
     * Количество элементов в списке.
     */
    private int size;

    /**
     * Конструктор по умолчанию. Создает пустой список с начальной емкостью по умолчанию.
     */
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления.
     */
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу, сдвигая остальные элементы при необходимости.
     *
     * @param index   Индекс, по которому следует вставить элемент.
     * @param element Элемент для вставки.
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона [0, size].
     */
    public void add(int index, E element) {
        ensureCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size); // сообщения выносим в константы и форматируем через string.format
        }

        // Сдвиг элементов для создания места под новый элемент
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента для получения.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона [0, size).
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    /**
     * Удаляет первое вхождение указанного элемента из списка, если он присутствует.
     *
     * @param element Элемент для удаления.
     */
    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                removeAtIndex(i);
                return;
            }
        }
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента для удаления.
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона [0, size).
     */
    private void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Сдвиг элементов для удаления элемента по указанному индексу
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Очищает список, устанавливая его размер в 0 и создавая новый массив.
     */
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Убеждается, что массив имеет достаточную емкость для добавления нового элемента.
     * Если необходимо, увеличивает размер массива в два раза.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return Текущий размер списка.
     */
    public int size() {
        return size;
    }
}