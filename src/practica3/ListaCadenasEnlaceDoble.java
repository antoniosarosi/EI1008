package practica3;

public class ListaCadenasEnlaceDoble implements ListaCadenas {

    private static class Node {
        String data;
        Node next;
        Node prev;

        Node(String data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node head;
    private Node last;

    // Constructor por defecto

    public boolean add(String s) {
        if (size == 0)
            head = last = new Node(s, null, null);
        else {
           last.next = new Node(s, null, last);
           last = last.next;
        }
        size++;
        return true;
    }

    public void add(int i, String s) {
        if (i < 0 || i > size)
            throw new IndexOutOfBoundsException();
        if (i == 0)
            head = new Node(s, head, null);
        else if (i == size) {
            add(s);
            return;
        }
        else {
            Node n = getNode(i);
            n.prev = new Node(s, n, n.prev);
            n.prev.prev.next = n.prev;
        }
        size++;
    }

    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    public String get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        return getNode(i).data;
    }

    public int indexOf(String s) {
        int position = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(s))
                return position;
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
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();

        String str;
        if (size == 1) {
            str = head.data;
            clear();
            return str;
        }
        else if (i == 0) {
            str = head.data;
            head = head.next;
            head.prev = null;
        }
        else if (i == size - 1) {
            str = last.data;
            last = last.prev;
            last.next = null;
        }
        else {
            Node n = getNode(i);
            str = n.data;
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        size--;
        return  str;
    }

    public boolean remove(String s) {
        if (head.data.equals(s)) {
            remove(0);
            return true;
        }
        if (last.data.equals(s)) {
            remove(size - 1);
            return true;
        }
        else {
            Node current = head;
            while (current != null) {
                if (current.data.equals(s)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    public String set(int i, String s) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        Node n = getNode(i);
        String str = n.data;
        n.data = s;
        return str;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (size == 0)
            return str.append("]").toString();

        str.append(head.data);
        Node current = head.next;
        while (current != null) {
            str.append(", ").append(current.data);
            current = current.next;
        }
        return str.append("]").toString();
    }

    public int removeAll(String s) {
        int previousSize = size;
        while (head != last && head.data.equals(s)) {
        head = head.next;
        head.prev = null;
        size--;
    }
        while (last != head && last.data.equals(s)) {
        last = last.prev;
        last.next = null;
        size--;
    }
        if (head.data.equals(s)) {
        head = last = null;
        size--;
        return previousSize;
    }
    Node current = head.next;
        while (current != null) {
        if (current.data.equals(s)) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
        current = current.next;
    }
        return previousSize - size;
}

    private Node getNode(int i) {
        Node current;
        if (i <= size / 2) {
            current = head;
            for (int j = 0; j < i; j++)
                current = current.next;
        } else {
            current = last;
            for (int j = 1; j < size - i; j++)
                current = current.prev;
        }
        return current;
    }

}
