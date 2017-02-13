package edu.sundot.adt;

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
        Node<T> reqNode = null;
        for (int i = 0; i < k; i++) {
            reqNode = lastNPointers.pop();
        }
        return reqNode.data;
    }

    public T getKthItemFromLast2(int k) {
        if (size() < k)
            return null;//TODO: replace with custom exception
        Queue<Node> lastNPointers = queueLastNPointersIgnoringHeadTail(k);
        Node<T> reqNode = lastNPointers.remove();
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

    public MySinglyLinkedList<Integer> addIntegersRec(MySinglyLinkedList l2) {
        this.equilengthBothList((MySinglyLinkedList<Integer>) this, l2);
        MySinglyLinkedList<Integer> resList = new MySinglyLinkedList();
        Node n1 = this.head.next;
        Node n2 = l2.head.next;
        int carry = this.addDigits((MySinglyLinkedList<Integer>) this, l2, n1, n2, resList);
        if (carry != 0)
            resList.insertAtFirst(carry);
        return resList;
    }

    public T findBegnningOfLoopElseNull() {
        Node<T> fastR = head.next;
        Node<T> slowR = head.next;
        while (fastR.next != null && fastR.next.next != null) {
            slowR = slowR.next;
            fastR = fastR.next.next;
            if (slowR == fastR) {
                break;
            }
        }

        if (fastR.next == null)
            return null;

        slowR = head.next;
        while (slowR != fastR) {
            slowR = slowR.next;
            fastR = fastR.next;
        }
        return fastR.data;
    }

    public static MySinglyLinkedList<String> getCircularList() {
        MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
        Node<String> a = new Node<>();
        a.data = "a";
        list.head.next = a;
        Node<String> b = new Node<>();
        b.data = "b";
        a.next = b;
        Node<String> c = new Node<>();
        c.data = "c";
        b.next = c;
        Node<String> d = new Node<>();
        d.data = "d";
        c.next = d;
        Node<String> e = new Node<>();
        e.data = "e";
        d.next = e;
        e.next = c;
        return list;
    }

    public boolean isPalindrome() {
        if (size < 2)
            return true;

        boolean res = true;
        Node<T> current = head.next;
        int d = size / 2;
        int q = size % 2;
        Stack<Node<T>> firstHalf = new Stack<>();
        for (int i = 0; i < d; i++) {
            firstHalf.push(current);
            current = current.next;
        }
        if (q != 0)
            current = current.next;
        while (!firstHalf.empty()) {
            //TODO: Replace with own stack implementation
            Node<T> item = firstHalf.pop();
            if (!item.data.equals(current.data)) {
                res = false;
                break;
            }
            current = current.next;
        }
        return res;
    }

    private void equilengthBothList(MySinglyLinkedList<Integer> l1, MySinglyLinkedList l2) {
        if (l1.size < l2.size) {
            this.setLeftPadZero(l1, l2.size - l1.size);
        } else if (l1.size > l2.size) {
            this.setLeftPadZero(l2, l1.size - l2.size);
        }
    }

    private void setLeftPadZero(MySinglyLinkedList<Integer> list, int padLength) {
        for (int i = 0; i < padLength; i++) {
            list.insertAtFirst(0);
        }
    }

    private int addDigits(MySinglyLinkedList<Integer> l1, MySinglyLinkedList<Integer> l2, Node n1, Node n2, MySinglyLinkedList<Integer> resList) {
        if (n1.next == l1.tail && n2.next == l2.tail) {
            int sum = (Integer) n1.data + (Integer) n2.data;
            int data = sum % 10;
            int carry = sum / 10;
            resList.insertAtFirst(data);
            return carry;
        } else {
            int carry = addDigits(l1, l2, n1.next, n2.next, resList);
            int sum = (Integer) n1.data + (Integer) n2.data + carry;
            int data = sum % 10;
            carry = sum / 10;
            resList.insertAtFirst(data);
            return carry;
        }
    }

    private void insertAtFirst(T item) {
        Node newNode = new Node();
        newNode.data = item;
        Node next = head.next;
        head.next = newNode;
        newNode.next = next;
        size = size + 1;
    }

    public static MySinglyLinkedList<Integer> addIntegers(MySinglyLinkedList<Integer> l1, MySinglyLinkedList l2) {
        Node n1 = l1.head.next;
        Node n2 = l2.head.next;
        MySinglyLinkedList<Integer> newList = new MySinglyLinkedList();
        Integer carry = 0;
        while (n1 != l1.tail && n2 != l2.tail) {
            Integer sum = Integer.parseInt(n1.data.toString()) + Integer.parseInt(n2.data.toString()) + carry;
            Integer data = sum % 10;
            carry = sum / 10;
            newList.add(data);
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != l1.tail) {
            Integer sum = Integer.parseInt(n1.data.toString()) + carry;
            Integer data = sum % 10;
            carry = sum / 10;
            newList.add(data);
            n1 = n1.next;
        }
        while (n2 != l2.tail) {
            Integer sum = Integer.parseInt(n2.data.toString()) + carry;
            Integer data = sum % 10;
            carry = sum / 10;
            newList.add(data);
            n2 = n2.next;
        }
        if (carry != 0) {
            newList.add(carry);
        }
        return newList;
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

        Node node = head.next;
        while (node != tail) {
            if (node.data.equals(item)) {
                this.removeNode(node);
                isSuccess = true;
                break;
            }
            node = node.next;
        }
        return isSuccess;
    }

    public MySinglyLinkedList<T> removeAndReturnCopy(T item) throws Exception {
        MySinglyLinkedList<T> newItems = new MySinglyLinkedList<T>();
        if (size > 0) {
            Node<T> current = this.head.next;
            while (current != this.tail) {
                if (!current.data.equals(item))
                    newItems.add(current.data);

                current = current.next;
            }
        } else {
            //TODO: Replace it to custom exception
            throw new Exception();
        }
        return newItems;
    }

    public void forEach(Consumer<T> consumer) {
        if (consumer != null) {
            Node<T> searchPtr = this.head.next;
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

    private void removeNode(Node node) {
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        this.size = this.size - 1;
    }

    private static class Node<T> {
        private Node next;
        private T data;
    }


}
