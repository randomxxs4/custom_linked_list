package company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomLinkedListImplTest {

    @Test
    public void add() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        assertTrue(list.add("sasha"));
        assertTrue(list.add("sasha2"));

        assertTrue(list.add(1, "dad3223"));
        assertTrue(list.add(2, "adadas"));
        assertFalse(list.add(34, "32123ada"));

        List<String> strings = new ArrayList<>();
        strings.add("sasas");
        strings.add("12343r2");
        strings.add("adad3");
        strings.add("aaaaaaaaa");
        strings.add("12ssssssss2");

        assertTrue(list.addAll(1, strings));
        assertTrue(list.addAll(strings));
        assertFalse(list.addAll(list.getSize() + 1, strings));
    }

    @Test
    public void remove() {

        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        assertTrue(list.remove(0));
        assertTrue(list.remove("test"));
        assertFalse(list.remove(5));
        assertFalse(list.remove("list"));

    }

    @Test
    public void removeFirst() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        assertTrue(list.removeFirst());
        assertTrue(list.removeFirst());
        assertTrue(list.removeFirst());
        assertFalse(list.removeFirst());


    }

    @Test
    public void removeLast() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        assertTrue(list.removeLast());
        assertTrue(list.removeLast());
        assertTrue(list.removeLast());
        assertFalse(list.removeLast());
    }

    @Test
    public void getElement() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        assertEquals("sasha", list.getElement(0));
        assertEquals("test", list.getElement("test"));
        assertNotEquals("123 ", list.getElement("123"));
        assertNotEquals("123.3", list.getElement(2));

    }

    @Test
    public void setLastNode() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        list.setLastNode("sasha_test");

        assertEquals("sasha_test", list.getLastElementValue());

    }

    @Test
    public void setFirstNode() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        list.setFirstNode("sasha_test");

        assertEquals("sasha_test", list.getFirstElementValue());
    }

    @Test
    public void getIndex() {
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl<>();
        list.add("sasha");
        list.add("test");
        list.add("123");

        assertEquals(0, list.getIndex("sasha"));
        assertEquals(1, list.getIndex("test"));
        assertEquals(2, list.getIndex("123"));
        assertEquals(-1, list.getIndex("121323"));
        assertEquals(-1, list.getIndex("1213asasas23"));
        assertEquals(-1, list.getIndex("121231323"));
        assertEquals(-1, list.getIndex("1214343323"));
    }
}