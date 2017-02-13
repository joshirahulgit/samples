package edu.sundot.adt;

import edu.sundot.adt.MyLinkedList;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rahul on 2/11/17.
 */
public class MyLinkedListTest {

    @Test
    public void add() {
        MyLinkedList<String> items = new MyLinkedList<>();
        for (int i = 0; i < 6; i++) {
            items.add("a" + i);
        }
        assert (items.size() == 6);
    }

    @Test
    public void remove() {
        MyLinkedList<String> items = getList();
        boolean res = true;
        res = items.remove("a0");
        if (res)
            res = items.remove("a2");
        if (res)
            res = items.remove("a5");
        assert (res && items.size() == 3);
    }

    int index = 0;

    @Test
    public void forEach() {
        MyLinkedList<String> items = getList();
        Object[] checkItems = {"a0", "a1", "a2", "a3", "a4", "a5"};
        String[] resItems = new String[items.size()];
        index = 0;
        items.forEach((s) -> this.add(resItems, s));
        assert (Arrays.equals(checkItems, resItems));
    }

    private void add(String[] resItems, String s) {
        resItems[index] = s;
        ++index;
    }

    @Test
    public void items() {
        Object[] checkItems = {"a0", "a1", "a2", "a3", "a4", "a5"};
        Object[] resItems = getList().items();
        assert (Arrays.equals(checkItems, resItems));
    }

    @Test
    public void size() {
        MyLinkedList<String> items = getList();
        items.remove("a3");
        assert (items.size() == 5);
    }

    @Test
    public void removeDuplicates() {
        Integer[] expected = {5, 4, 6, 57, 2};

        MyLinkedList<Integer> items = new MyLinkedList<>();
        items.add(5);
        items.add(4);
        items.add(6);
        items.add(5);
        items.add(57);
        items.add(5);
        items.add(4);
        items.add(2);

        items.removeDuplicates();

        assert (Arrays.equals(items.items(), expected));
    }

    @Test
    public void removeDuplicatesWithoutBuffer() {
        Integer[] expected = {5, 4, 6, 55, 2};

        MyLinkedList<Integer> items = new MyLinkedList<>();
        items.add(5);
        items.add(4);
        items.add(6);
        items.add(5);
        items.add(55);
        items.add(5);
        items.add(4);
        items.add(2);

        items.removeDuplicates();

        assert (Arrays.equals(items.items(), expected));
    }

    @Test
    public void partitionAroundValue() {
        Integer[] expected = {4, 2, 5, 7, 9, 7, 5, 6};

        MyLinkedList<Integer> items = new MyLinkedList<>();
        items.add(5);
        items.add(4);
        items.add(6);
        items.add(5);
        items.add(7);
        items.add(2);
        items.add(9);
        items.add(7);

        Object[] result = items.partitionAroundValue(5, Integer::compareTo).items();
        assert (Arrays.equals(result, expected));
    }

    private MyLinkedList<String> getList() {
        MyLinkedList<String> items = new MyLinkedList<String>();
        for (int i = 0; i < 6; i++) {
            items.add("a" + i);
        }
        return items;
    }

}