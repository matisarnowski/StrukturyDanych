package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List list = new List();
        Scanner sc = new Scanner(System.in);
        String argument, number;
        int numberInt;

        while (true) {
            System.out.println("Wybierz operację, którą chcesz przeprowadzić na liście dwukierunkowej: "
                    + "Wybierz operację: \n" +
                    "    ADD_FIRST,\n" +
                    "    ADD_LAST,\n" +
                    "    POLL_FIRST,\n" +
                    "    POLL_LAST,\n" +
                    "    PEEK_FIRST,\n" +
                    "    PEEK_LAST,\n" +
                    "    SHOW,\n" +
                    "    SHOW_REVERSE,\n" +
                    "    IS_EMPTY,\n" +
                    "    SEARCH,\n" +
                    "lub QUIT, aby wyjść");
            argument = sc.next();

            if (argument.equals("QUIT")) {
                break;
            }

            switch (Operation.valueOf(argument)) {
                case ADD_FIRST:
                    System.out.println("Podaj liczbę całkowitą, którą chcesz dodać na początek: ");
                    try {
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        list.addFirst(numberInt);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case ADD_LAST:
                    System.out.println("Podaj liczbę całkowitą, którą chcesz dodać na koniec: ");
                    try {
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        list.addLast(numberInt);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case POLL_FIRST:
                    System.out.println("Zdejmij liczbę na początku: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.pollFirst());
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                    break;
                case POLL_LAST:
                    System.out.println("Zdejmij liczbę na końcu: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.pollLast());
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                    break;
                case PEEK_FIRST:
                    System.out.println("Podejrzyj liczbę na początku: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.peekFirst());
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                    break;
                case PEEK_LAST:
                    System.out.println("Podejrzyj liczbę na końcu: ");
                    try {
                        System.out.println("Ta liczba, to: " + list.peekLast());
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                    break;
                case SHOW:
                    try {
                        System.out.println("Tadam!");
                        list.show();
                        break;
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                case SHOW_REVERSE:
                    try {
                        System.out.println("Tadam");
                        list.showReverse();
                        break;
                    } catch (ListEmptyException e) {
                        e.printStackTrace();
                    }
                case IS_EMPTY:
                    System.out.println("Lista pusta TRUE/FALSE: " + list.isEmpty());
                    break;
                case SEARCH:
                    try {
                        System.out.println("Podaj element, który chcesz wyszukać.");
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        ListItem elem = list.search(numberInt);
                        System.out.println("Znaleziono element: " + elem.getValue());
                        break;
                    }
                    catch (NumberFormatException | NullPointerException e){
                        System.out.print("Nie znaleziono elementu ");
                        e.printStackTrace();
                        break;
                    }
                case REMOVE:
                    try {
                        System.out.println("Podaj element, który chcesz wyszukać.");
                        number = sc.next();
                        numberInt = Integer.parseInt(number);
                        boolean equal = list.remove(numberInt);
                        if (equal == true){
                            System.out.println("Usunięto element " + numberInt);
                        }
                        else {
                            System.out.println("Nie znaleziono elementu " + numberInt);
                        }
                        break;
                    }
                    catch (NumberFormatException e){
                        System.out.print("Nie znaleziono elementu ");
                        e.printStackTrace();
                        break;
                    }
                default:
                    throw new IllegalStateException("Unexpected value: " + Operation.valueOf(argument));
            }
        }
    }
}
