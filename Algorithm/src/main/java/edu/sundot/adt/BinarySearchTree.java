package edu.sundot.adt;

import java.util.Objects;

/**
 * Created by rahul on 2/13/17.
 */
public class BinarySearchTree<T extends Comparable> {

    private BinarySearchTreeNode<T> root;
    private int size;

    public BinarySearchTree() {

    }

    public int height() {
        return root.height;
    }

    public void add(T data) {
        BinarySearchTreeNode<T> newNode = getNewInternalNode(data);
        if (root == null) {
            root = newNode;
        } else {
            attachChild(root, newNode);
        }
        size = size + 1;
    }

    private BinarySearchTreeNode<T> getNewInternalNode(T data) {
        BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<>(BinarySearchTreeNodeType.INTERNAL);
        newNode.data = data;
        newNode.height = 1;
        newNode.left = getNewExternalNode();
        newNode.right = getNewExternalNode();
        return newNode;
    }

    private void attachChild(BinarySearchTreeNode<T> node, BinarySearchTreeNode<T> newNode) {
        if (node.data.compareTo(newNode.data) == 1) {
            if (node.left.isExternal()) {
                node.left = newNode;
                newNode.parent = node;
            } else {
                this.attachChild(node.left, newNode);
            }
        } else {
            if (node.right.isExternal()) {
                node.right = newNode;
                newNode.parent = node;
            } else {
                this.attachChild(node.right, newNode);
            }
        }
        if (!isNodeBalanced(node)) {
            balanceNode(node);
        }

        this.setHeight(node);
    }

    private void balanceNode(BinarySearchTreeNode<T> node) {
        if (node.left.height > node.right.height)
            rotateRight(node);
        else
            rotateLeft(node);
    }

    private void rotateLeft(BinarySearchTreeNode<T> node) {
        if (node.hasParent()) {
            BinarySearchTreeNode<T> parent = node.parent;
            if (node.right.right.isExternal())
                shiftAllRight(node.right);
            parent.right = node.right;
            node.right.parent = parent;
            node.right.left = node;
            node.right = getNewExternalNode();
        } else {
            root = node.right;
            root.parent = null;
            node.right.left = node;
            node.right = getNewExternalNode();
        }
    }

    private void rotateRight(BinarySearchTreeNode<T> node) {
        if (node.hasParent()) {
            BinarySearchTreeNode<T> parent = node.parent;
            if (node.left.left.isExternal())
                shiftAllLeft(node.left);
            parent.left = node.left;
            node.left.parent = parent;
            node.left.right = node;
            node.left = getNewExternalNode();
        } else {
            root = node.left;
            root.parent = null;
            node.left.right = node;
            node.left = getNewExternalNode();
        }
    }

    private void shiftAllLeft(BinarySearchTreeNode node) {
        BinarySearchTreeNode<T> parent = node.parent;
        parent.left = node.right;
        parent.left.left = node;
        node.right = getNewExternalNode();
    }

    private void shiftAllRight(BinarySearchTreeNode node) {
        BinarySearchTreeNode<T> parent = node.parent;
        parent.right = node.left;
        parent.right.right = node;
        node.left = getNewExternalNode();
    }

    private BinarySearchTreeNode<T> getNewExternalNode() {
        return new BinarySearchTreeNode(BinarySearchTreeNodeType.EXTERNAL);
    }

    private boolean isNodeBalanced(BinarySearchTreeNode<T> node) {
        return Math.abs(node.left.height - node.right.height) <= 1;
    }

    private void setHeight(BinarySearchTreeNode<T> node) {
        if (node.left.height > node.right.height) {
            node.height = node.left.height + 1;
        } else {
            node.height = node.right.height + 1;
        }
    }

    public int Size() {
        return size;
    }

    public class BinarySearchTreeNode<T> {
        private T data;
        private BinarySearchTreeNode left;
        private BinarySearchTreeNode right;
        private int height;
        private BinarySearchTreeNodeType binarySearchTreeNodeType;

        private BinarySearchTreeNode<T> parent;

        public BinarySearchTreeNode(BinarySearchTreeNodeType type) {
            binarySearchTreeNodeType = type;
        }

        public boolean isExternal() {
            return binarySearchTreeNodeType == BinarySearchTreeNodeType.EXTERNAL;
        }

        public boolean isInternal() {
            return binarySearchTreeNodeType == BinarySearchTreeNodeType.INTERNAL;
        }

        public BinarySearchTreeNode<T> getParent() {
            return parent;
        }

        @Override
        public String toString() {
            return " {data:" + (Objects.isNull(data) ? "NULL" : data) + "}";
        }

        public boolean hasParent() {
            return parent != null;
        }
    }

    public enum BinarySearchTreeNodeType {
        EXTERNAL,
        INTERNAL
    }
}
