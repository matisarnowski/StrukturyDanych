package com.company;

public class List {
    private ListItem first;
    private ListItem last;

    public List() {
        this.first = null;
        this.last = null;
    }

    public void addFirst(int value) {
        if (isEmpty()) {
            ListItem elem = new ListItem(value, null, null);
            first = last = elem;
        } else {
            ListItem elem = new ListItem(value, getFirst(),null);
            first.setPrev(elem);
            first = elem;
        }
    }

    public void addLast(int value) {
        if (isEmpty()) {
            ListItem elem = new ListItem(value, null, null);
            first = last = elem;
        } else {
            ListItem elem = new ListItem(value, null, getLast());
            last.setNext(elem);
            last = elem;
        }
    }


    public int pollFirst() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        int value = first.getValue();
        if (first == last) {
            first = last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        return value;
    }

    public int pollLast() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        int value = last.getValue();
        if (first == last) {
            first = last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }
        return value;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        return last.getValue();
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }

        return first.getValue();
    }

    public boolean isEmpty() {
        return ((last == null) && (first == null));
    }

    public void show() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        System.out.println("Wypisuję listę od początku!");
        ListItem tmp = first;
        if (first == last){
            System.out.println(tmp.getValue());
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public void showReverse() {
        if (isEmpty()) {
            throw new ListEmptyException();
        }
        System.out.println("Wypisuję listę od końca!");
        ListItem tmp = last;
        if (first == last){
            System.out.println(tmp.getValue());
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getPrev();
        }
        System.out.println();
    }

    public ListItem getFirst() {
        return first;
    }

    public ListItem getLast() {
        return last;
    }
}
