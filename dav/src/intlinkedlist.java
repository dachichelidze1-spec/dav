import java.util.NoSuchElementException;

public class intlinkedlist {
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    private Node head;
    private Node tail;
    private int size;


     intlinkedlist() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(int v) {
        addLast(v);
    }

    public void addFirst(int v1) {
        Node newNode = new Node(v1);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void add(int index, int value) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node prev = getNode(index - 1);
        Node newNode = new Node(value);

        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    private Node getNode(int index) {
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
    public int get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    public void set(int index, int value) {
        checkIndex(index);
        getNode(index).value = value;
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.value;
    }

    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.value;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
}
