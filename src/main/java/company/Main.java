package company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedListImpl<>();
        list.add("sasha0");
        list.add("sasha1");
        list.add("sasha2");
        list.add("sasha3");
        list.add("sasha4");
        list.add("sasha5");
        Iterator iterator = list.iterator(0);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
