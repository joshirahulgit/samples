package edu.sundot.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rahul on 2/11/17.
 */
public class MySinglyLinkedListTest {
    @Test
    public void add() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(5);
        items.add(7);
        items.add(10);

//        items.forEach(System.out::println);
        assert (items.size() == 3);
    }

    @Test
    public void getKthItemFromLast() {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(25);
        items.add(67);
        items.add(88);
        items.add(98);

//        items.forEach(System.out::println);
        assert (items.getKthItemFromLast(2) == 88);
    }

    @Test
    public void getKthItemFromLast2() {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(25);
        items.add(67);
        items.add(78);
        items.add(98);

//        items.forEach(System.out::println);
        assert (items.getKthItemFromLast(2) == 78);
    }

    @Test
    public void remove() throws Exception {
        Integer[] expected = {25, 78, 98};

        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(25);
        items.add(67);
        items.add(78);
        items.add(98);

        items.remove(67);
        assert (Arrays.equals(expected, items.items()));
    }

    @Test
    public void size() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(25);
        items.add(67);
        items.add(78);
        items.add(98);

        items.remove(67);
        assert (items.size() == 3);
    }

    @Test
    public void removeAndReturnCopy() throws Exception {
        String[] expected = {"A", "B", "D", "E"};

        MySinglyLinkedList<String> items = new MySinglyLinkedList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        MySinglyLinkedList<String> resultList = items.removeAndReturnCopy("C");
        items.remove("C");
        assert (Arrays.equals(expected, resultList.items()));
    }
}