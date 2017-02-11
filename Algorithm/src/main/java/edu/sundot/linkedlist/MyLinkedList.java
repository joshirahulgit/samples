package edu.sundot.linkedlist;

import java.util.function.Consumer;

/**
 * Created by rahul on 2/11/17.
 */
public class MyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public void add(T item) {
        Node newNode = new Node();
        Node previous = this.tail.previous;
        newNode.data = item;
        newNode.previous = this.tail.previous;
        newNode.next = this.tail;
        previous.next = newNode;
        this.tail.previous = newNode;
        this.size = this.size + 1;
    }

    public boolean remove(T item) {
        Node searchPtr = this.head.next;
        boolean itemFoundAndRemoved = false;
        while (searchPtr != this.tail) {
            if (searchPtr.data.equals(item)) {
                this.removeItem(searchPtr);
                itemFoundAndRemoved = true;
                break;
            }
            searchPtr = searchPtr.next;
        }
        if (itemFoundAndRemoved) {
            this.size = this.size - 1;
        }
        return itemFoundAndRemoved;
    }

    public void forEach(Consumer<T> consumer) {
        if (consumer != null) {
            Node searchPtr = this.head.next;
            while (searchPtr != this.tail) {
                consumer.accept(searchPtr.data);
                searchPtr = searchPtr.next;
            }
        }
    }

    public Object[] items() {
        Object[] items = new Object[this.size];
        Node searchPtr = this.head.next;
        int index = 0;
        while (searchPtr != this.tail) {
            items[index] = searchPtr.data;
            searchPtr = searchPtr.next;
            ++index;
        }
        return items;
    }

    public int size() {
        return this.size;
    }

    private void removeItem(Node srchPtr) {
        Node previous = srchPtr.previous;
        Node next = srchPtr.next;
        next.previous = previous;
        previous.next = next;
    }

    class Node {
        private Node next;
        private Node previous;
        private T data;
    }
}
