package edu.sundot.adt;

import java.util.Comparator;
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
        newNode.data = item;
        add(newNode);
    }

    //TODO: write test
    public MyLinkedList<T> partitionAroundValue(T value, Comparator<T> comparator) {
        MyLinkedList<T> newList = new MyLinkedList<T>();
        Node valueNode = findFirstValue(value);
        Node runnerNode = head.next;
        Node partitionNode = new Node();
        partitionNode.data = valueNode.data;
        newList.add(partitionNode);
        while (runnerNode != tail) {
            if (runnerNode == valueNode) {
                runnerNode = runnerNode.next;
                continue;
            }

            if (comparator.compare(runnerNode.data, valueNode.data) == -1) {
                Node newNode = new Node();
                newNode.data = runnerNode.data;
                newList.insertBefore(newNode, partitionNode);
            } else {
                Node newNode = new Node();
                newNode.data = runnerNode.data;
                newList.insertAfter(newNode, partitionNode);
            }
            runnerNode = runnerNode.next;
        }
        return newList;
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

    private Node findFirstValue(T value) {
        if (size > 0) {
            Node current = head.next;
            while (current != this.tail) {
                if (current.data.equals(value)) {
                    return current;
                }
                current = current.next;
            }
        } else {
            //TODO: throw exception
        }
        return tail;
    }

    private void add(Node newNode) {
        Node previous = this.tail.previous;
        newNode.previous = this.tail.previous;
        newNode.next = this.tail;
        previous.next = newNode;
        this.tail.previous = newNode;
        this.size = this.size + 1;
    }

    private void insertBefore(Node newNode, Node node) {
        Node previous = node.previous;
        previous.next = newNode;
        newNode.previous = previous;
        newNode.next = node;
        node.previous = newNode;
        size = size + 1;
    }

    private void insertAfter(Node newNode, Node node) {
        Node next = node.next;
        newNode.next = next;
        next.previous = newNode;
        newNode.previous = node;
        node.next = newNode;
        size = size + 1;
    }

    private void setRunnerPrevious(Node valueNode, Node runnerNode) {
        runnerNode = this.unplugNode(runnerNode);
        Node previous = valueNode.previous;
        previous.next = runnerNode;
        runnerNode.previous = previous;
        runnerNode.next = valueNode;
        valueNode.previous = runnerNode;
    }

    private void setRunnerNext(Node valueNode, Node runnerNode) {
        runnerNode = unplugNode(runnerNode);
        Node next = valueNode.next;
        valueNode.next = runnerNode;
        runnerNode.previous = valueNode;
        runnerNode.next = next;
        next.previous = runnerNode;
    }

    private Node unplugNode(Node runnerNode) {
        Node previous = runnerNode.previous;
        Node next = runnerNode.next;
        previous.next = next;
        next.previous = previous;
        return runnerNode;
    }

    private class Node {
        private Node next;
        private Node previous;
        private T data;
    }
}
