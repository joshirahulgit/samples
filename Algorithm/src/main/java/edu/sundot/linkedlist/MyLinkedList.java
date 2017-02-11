package edu.sundot.linkedlist;

import java.util.HashSet;
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

    public void removeDuplicates() {
        if (this.size() < 2)
            return;

        Node node = head.next;
        HashSet<T> uniqueCheckList = new HashSet<T>();
        while (node != tail) {
            if (!uniqueCheckList.contains(node.data))
                uniqueCheckList.add(node.data);

            else {
                this.removeNode(node);
            }
            node = node.next;
        }
    }

    public void removeDuplicatesWithoutBuffer() {
        if (this.size() < 2)
            return;

        Node p1 = head.next;
        Node p2 = p1.next;
        while (p1.next != tail) {
            while (p2 != tail) {
                if (p1.data.equals(p2.data)) {
                    Node tobeRemoved = p2;
                    removeNode(tobeRemoved);
                }
                p2 = p2.next;
            }
            p1 = p1.next;
            p2 = p1.next;
        }
    }

    public boolean remove(T item) {
        Node searchPtr = this.head.next;
        boolean itemFoundAndRemoved = false;
        while (searchPtr != this.tail) {
            if (searchPtr.data.equals(item)) {
                this.removeNode(searchPtr);
                itemFoundAndRemoved = true;
                break;
            }
            searchPtr = searchPtr.next;
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

    private void removeNode(Node srchPtr) {
        Node previous = srchPtr.previous;
        Node next = srchPtr.next;
        next.previous = previous;
        previous.next = next;
        this.size = this.size - 1;
    }

    private class Node {
        private Node next;
        private Node previous;
        private T data;
    }
}
