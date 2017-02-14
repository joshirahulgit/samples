package edu.sundot.adt;

import org.junit.Test;

/**
 * Created by rahul on 2/13/17.
 */
public class BinarySearchTreeTest {
    @Test
    public void testAddNodes() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(2);
        tree.add(1);

        assert (tree.Size() == 6);
    }

    @Test
    public void testBalanceRootNodes() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(8);

        assert (tree.Size() == 3);
    }



}