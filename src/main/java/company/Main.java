package company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        System.out.println("-------------------------------------");
        CustomLinkedListImpl<String> li = new CustomLinkedListImpl<>();
        li.add("sasha0");
        li.add("sasha1");
        li.add("sasha2");
        List<String> strings = new ArrayList<>();
        strings.add("sasas");
        strings.add("12343r2");
        strings.add("adad3");
        strings.add("aaaaaaaaa");
        strings.add("12ssssssss2");

        li.addAll(1, strings);
        li.addAll(strings);

        Iterator iterator2 = li.iterator(0);
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
