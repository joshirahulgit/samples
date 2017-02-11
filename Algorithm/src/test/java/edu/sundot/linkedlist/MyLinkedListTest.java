package edu.sundot.linkedlist;

import java.util.Arrays;

/**
 * Created by rahul on 2/11/17.
 */
public class MyLinkedListTest {

    @org.junit.Test
    public void add() {
        MyLinkedList<String> items = new MyLinkedList<>();
        for (int i = 0; i < 6; i++) {
            items.add("a" + i);
        }
        assert (items.size() == 6);
    }

    @org.junit.Test
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

    @org.junit.Test
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

    @org.junit.Test
    public void items() {
        Object[] checkItems = {"a0", "a1", "a2", "a3", "a4", "a5"};
        Object[] resItems = getList().items();
        assert (Arrays.equals(checkItems, resItems));
    }

    @org.junit.Test
    public void size() {
        assert (getList().size() == 6);
    }

    private MyLinkedList<String> getList() {
        MyLinkedList<String> items = new MyLinkedList<String>();
        for (int i = 0; i < 6; i++) {
            items.add("a" + i);
        }
        return items;
    }

}