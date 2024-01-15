package dataStructures;

public class LinkedList {

    // TODO indexOf

    private Node first;
    private Node last;
    private int count = 0;

    private class Node {
        int value;
        Node next;

        Node(int item) {
            value = item;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (first == null)
            first = last = node;
        else {
            var oldFirst = first;
            node.next = oldFirst;
            first = node;
        }

        count++;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (last == null)
            first = last = node;
        else {

            last.next = node;
            last = node;
        }

        count++;
    }

    public int deleteFirst() {
        var oldFirst = first;
        first = first.next;
        oldFirst.next = null;
        count--;

        return oldFirst.value;
    }

    public int deleteLast() {
        var oldLast = last;
        last = getPreviousNode(last);
        last.next = null;
        count--;

        return oldLast.value;
    }

    private Node getPreviousNode(Node node) {
        var current = first;

        while (current.next != node) {
            current = current.next;
        }

        return current;

    }

    public boolean contains(int item) {
        var current = first;
        while (current != null) {
            if (current.value == item)
                return true;

            current = current.next;
        }

        return false;
    }

    public void print() {
        var node = first;
        for (int i = 0; i < count; i++) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
