package edu.sundot.linkedlist;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;

/**
 * Created by rahul on 2/11/17.
 */
public class MySinglyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MySinglyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
    }

    public void add(T item) {
        Stack<Node> p = this.stackLastNPointers(2);
        Node tail = p.pop();
        Node head = p.pop();
        Node newNode = new Node();
        newNode.data = item;
        insertNode(head, tail, newNode);
    }

    public T getKthItemFromLast(int k) {
        if (size() < k)
            return null;//TODO: replace with custom exception
        Stack<Node> lastNPointers = stackLastNPointersIgnoringHeadTail(k);
        Node reqNode = null;
        for (int i = 0; i < k; i++) {
            reqNode = lastNPointers.pop();
        }
        return reqNode.data;
    }

    public T getKthItemFromLast2(int k) {
        if (size() < k)
            return null;//TODO: replace with custom exception
        Queue<Node> lastNPointers = queueLastNPointersIgnoringHeadTail(k);
        Node reqNode = lastNPointers.remove();
        return reqNode.data;
    }

    private Stack<Node> stackLastNPointersIgnoringHeadTail(int k) {
        Stack<Node> nodes = new Stack<>();

        Node current = head.next;
        while (current != tail) {
            nodes.push(current);
            current = current.next;
        }
        return nodes;

    }

    private Queue<Node> queueLastNPointersIgnoringHeadTail(int k) {
        Queue<Node> nodes = new ArrayBlockingQueue<Node>(k);

        Node current = head.next;
        while (current != tail) {
            nodes.add(current);
            current = current.next;
        }
        return nodes;

    }

    private void insertNode(Node previous, Node next, Node newNode) {
        previous.next = newNode;
        newNode.next = next;
        size = size + 1;
    }

    private Stack<Node> stackLastNPointers(int count) {
        Stack<Node> nodes = new Stack<>();

        Node current = head; // Push head to link new item to head
        while (current != tail) {
            nodes.push(current);
            current = current.next;
        }
        nodes.push(current); // Push tail also to link it to new Item.
        return nodes;
    }

    public boolean remove(T item) {
        boolean isSuccess = false;

        if (size < 1)
            return isSuccess;

        Node p0 = this.head.next;
        Node p1 = p0.next;
        while (p1 != tail) {
            if (p1.data.equals(item)) {
                this.removeNode(p0, p1);
                isSuccess = true;
                break;
            }
            p0 = p1;
            p1 = p1.next;
        }
        return isSuccess;
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

    private void removeNode(Node previous, Node current) {
        Node next = current.next;
        previous.next = next;
        this.size = this.size - 1;
    }

    private class Node {
        private Node next;
        private T data;
    }


}
