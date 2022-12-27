package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int elementsCount = 0;

    public CustomTree() {
        root = new Entry<>("root");
    }

    @Override
    public boolean add(String s) {
        elementsCount++;
        return root.add(s);
    }

    public String getParent(String s) {
        return root.getParentOf(s);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public boolean add(String node) {
            if (isAvailableToAddChildren()) {
                if (availableToAddLeftChildren) {
                    leftChild = new Entry<>(node);
                    leftChild.parent = this;
                    availableToAddLeftChildren = false;
                } else {
                    rightChild = new Entry<>(node);
                    rightChild.parent = this;
                    availableToAddRightChildren = false;
                }
                return true;
            } else {
                if (leftChild.isAvailableToAddChildren()) {
                    return leftChild.add(node);
                } else if (rightChild.isAvailableToAddChildren()) {
                    return rightChild.add(node);
                }
            }
            return leftChild.add(node);
        }


        public String getParentOf(String s) {
            if (leftChild != null) {
                if (leftChild.elementName.equals(s)) return elementName;
                else {
                    String parentOf = leftChild.getParentOf(s);
                    if (parentOf != null) return parentOf;
                }
            }
            if (rightChild != null) {
                if (rightChild.elementName.equals(s)) return elementName;
                else {
                    String parentOf = rightChild.getParentOf(s);
                    if (parentOf != null) return parentOf;
                }
            }
            return null;
        }
    }
}
