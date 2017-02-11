package edu.sundot.linkedlist;

import java.util.LinkedList;

/**
 * Created by rahul on 2/11/17.
 */
public class RunnerExmppleLinkedList {

    LinkedList<String> items = new LinkedList<String>();

    Node p1;
    Node p2;
    Node start;

    private void initialize() {
        items.add("a1");
        items.add("a2");
        items.add("a3");
        items.add("a4");
        items.add("b1");
        items.add("b2");
        items.add("b3");
        items.add("b4");

//        p1=items.getFirst().

//        Node a1 = new Node();
//        a1.data = "a1";
//        Node a2 = addDataNextTo(a1, "a2");
//        Node a3 = addDataNextTo(a2, "a3");
//        Node a4 = addDataNextTo(a3, "a4");
//        Node b1 = addDataNextTo(a4, "b1");
//        Node b2 = addDataNextTo(b1, "b2");
//        Node b3 = addDataNextTo(b2, "b3");
//        Node b4 = addDataNextTo(b3, "b4");
//        start = a1;
    }

    public void rearrange() {
        p1 = start;
        if (start.next != null)
            p2 = start.next;
    }

    private Node addDataNextTo(Node a, String aNext) {
        Node next = new Node();
        next.data = aNext;
        next.previous = a;
        a.next = next;
        return next;
    }

    class Node {
        private Node next;
        private Node previous;
        private String data;
    }
}
