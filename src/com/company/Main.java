package com.company;

public class Main {

    public static void main(String[] args) {
        MyCreatedList list = new MyCreatedList();
        list.add(15);
        list.add(10);
        list.add(1);
        System.out.println(list);
        System.out.println(list.contains(12));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(0));

    }
}
