package edu.sundot.adt;

import org.junit.Test;

/**
 * Created by rahul on 2/13/17.
 */
public class BinarySearchTreeTest {
    @Test
    public void testBalanceTreeWithRightRotation() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(2);
        tree.add(1);

        assert (tree.Size() == 6);
        assert (tree.height() == 3);
    }

    @Test
    public void testBalanceRootNodes() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(8);

        assert (tree.Size() == 3);
        assert (tree.height() == 2);
    }

    @Test
    public void testBalanceTreeWithLeftRightRotation() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(18);
        tree.add(15);
        tree.add(25);
        tree.add(30);
        tree.add(5);
        tree.add(7);
        tree.add(11);

        assert (tree.height() == 4);
    }
}