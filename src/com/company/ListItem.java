package com.company;

public class ListItem {
    private int value;
    private ListItem next;
    private ListItem prev;

    public ListItem(int value, ListItem next, ListItem prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public ListItem getNext() {
        return next;
    }

    public ListItem getPrev() {
        return prev;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }

    public void setPrev(ListItem prev) {
        this.prev = prev;
    }
}
