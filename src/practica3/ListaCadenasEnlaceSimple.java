package practica3;

public class ListaCadenasEnlaceSimple implements ListaCadenas {

    private static class Node {
        String data;
        Node next;

        Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;

    // Constructor por defecto

    public boolean add(String s) {
        if (size == 0) head = new Node(s, null);
        else {
            Node current = head;
            while (current.next != null)
                current = current.next;

            current.next = new Node(s, null);
        }
        size++;
        return true;
    }

    public void add(int i, String s) {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException();
        if (i == 0) head = new Node(s, head);
        else {
            Node current = head;
            for (int j = 0; j < i - 1; j++)
                current = current.next;

            current.next = new Node(s, current.next);
        }
        size++;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public String get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int j = 0; j < i; j++)
            current = current.next;
        return current.data;
    }

    public int indexOf(String s) {
        int position = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(s)) return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    public int lastIndexOf(String s) {
        int position = 0, savePosition = -1;
        Node current = head;

        while (current != null) {
            if (current.data.equals(s))
                savePosition = position;

            current = current.next;
            position++;
        }
        return savePosition;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String remove(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        String str;

        if (i == 0) {
            str = head.data;
            head = head.next;
        }
        else {
            Node current = head;
            for (int j = 0; j < i - 1; j++)
                current = current.next;

            str = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return str;
    }

    public boolean remove(String s) {
        if (head.data.equals(s)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head, prev = head;
        while (current != null) {
            if (current.data.equals(s)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public String set(int i, String s) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int j = 0; j < i; j++)
            current = current.next;

        String str = current.data;
        current.data = s;
        return str;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (size == 0) return str.append("]").toString();

        str.append(head.data);
        Node current = head.next;
        while (current != null) {
            str.append(", ").append(current.data);
            current = current.next;
        }
        return str.append("]").toString();
    }

//    public int removeAll(String s) {
//        int previousSize = size;
//        while (head != null && head.data.equals(s)) {
//            head = head.next;
//            size--;
//        }
//        if (head == null)
//            return previousSize;
//
//        Node prev = head;
//        Node current = head.next;
//        while (current != null) {
//            if (current.data.equals(s)) {
//                do {
//                    current = current.next;
//                    size--;
//                } while (current != null && current.data.equals(s));
//                prev.next = current;
//                if (current == null)
//                    return previousSize - size;
//            }
//            prev = current;
//            current = current.next;
//        }
//        return previousSize - size;
//    }

    public int removeAll(String s) {
        int previousSize = size();
        removeAllRecursively(head, head.next, s);
        return previousSize - size();
    }

    private void removeAllRecursively(Node current, Node next, String s) {
        if (next == null) {
            if (current.data.equals(s)) clear();
            return;
        }
        if (head.data.equals(s)) {
            head = head.next;
            size--;
            removeAllRecursively(head, head.next, s);
        }
        else if (next.data.equals(s)) {
            current.next = next.next;
            size--;
            removeAllRecursively(current, current.next, s);
        }
        else removeAllRecursively(current.next, next.next, s);
    }

}
