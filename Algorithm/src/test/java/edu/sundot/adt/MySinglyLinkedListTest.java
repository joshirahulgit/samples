package edu.sundot.adt;

import edu.sundot.adt.MySinglyLinkedList;
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
    public void isPalindromeWithEvenSize() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(2);
        items.add(5);
        items.add(5);
        items.add(2);

        assert (items.isPalindrome());
    }

    @Test
    public void isPalindromeWithOddSize() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(2);
        items.add(5);
        items.add(9);
        items.add(5);
        items.add(2);

        assert (items.isPalindrome());
    }

    @Test
    public void isNotPalindromeWithOddSize() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(2);
        items.add(7);
        items.add(9);
        items.add(5);
        items.add(2);

        assert (!items.isPalindrome());
    }

    @Test
    public void isNotPalindromeWithEvenSize() throws Exception {
        MySinglyLinkedList<Integer> items = new MySinglyLinkedList<>();
        items.add(2);
        items.add(7);
        items.add(5);
        items.add(2);

        assert (!items.isPalindrome());
    }

    @Test
    public void addIntegers() {
        Integer[] expected = {2, 1, 9};

        MySinglyLinkedList<Integer> l1 = new MySinglyLinkedList<>();
        l1.add(7);
        l1.add(1);
        l1.add(6);
        MySinglyLinkedList<Integer> l2 = new MySinglyLinkedList<>();
        l2.add(5);
        l2.add(9);
        l2.add(2);
        MySinglyLinkedList<Integer> l3 = MySinglyLinkedList.addIntegers(l1, l2);

        assert (Arrays.equals(l3.items(), expected));
    }

    @Test
    public void getCircularList() {
        MySinglyLinkedList<String> items = MySinglyLinkedList.getCircularList();
        String c = items.findBegnningOfLoopElseNull();
        assert (c.equals("c"));
    }

    @Test
    public void addIntegersRec() {
        Integer[] expected = {9, 1, 2};

        MySinglyLinkedList<Integer> l1 = new MySinglyLinkedList<>();
        l1.add(6);
        l1.add(1);
        l1.add(7);
        MySinglyLinkedList<Integer> l2 = new MySinglyLinkedList<>();
        l2.add(2);
        l2.add(9);
        l2.add(5);
        MySinglyLinkedList<Integer> l3 = l1.addIntegersRec(l2);

        assert (Arrays.equals(l3.items(), expected));
    }

    @Test
    public void addIntegersRecWithUnequalLength() {
        Integer[] expected = {1, 0, 2, 1, 2};

        MySinglyLinkedList<Integer> l1 = new MySinglyLinkedList<>();
        l1.add(9);
        l1.add(6);
        l1.add(1);
        l1.add(7);
        MySinglyLinkedList<Integer> l2 = new MySinglyLinkedList<>();
        l2.add(5);
        l2.add(9);
        l2.add(5);
        MySinglyLinkedList<Integer> l3 = l1.addIntegersRec(l2);

        assert (Arrays.equals(l3.items(), expected));
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