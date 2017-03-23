package com.industriallogic.understand;

import com.industriallogic.collections.List;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;

public class ListTest {
    @Test
    public void testAddNull(){
        List list = new List();
        list.add(null);
    }

    @Test
    public void testAddWithReadOnly(){
        List list = new List();
        assertFalse(list.getReadOnly());

        list.setReadOnly(true);

        assertTrue(list.getReadOnly());

        list.add(null);

        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
        assertNull(list.get(0));

        list.add("Whatever");

        assertEquals(0,list.size());
        assertTrue(list.isEmpty());
        assertNull(list.get(0));
    }

    @Test
    public void testAdd(){
        List list = new List();

        list.add(null);

        assertEquals(1,list.size());
        assertFalse(list.isEmpty());
        assertNull(list.get(0));

        list.add("Whatever");

        assertEquals(2,list.size());
        assertFalse(list.isEmpty());
        assertNotNull(list.get(1));
    }

    @Test
    public void testCapacity(){
        List list = new List();
        assertEquals(10,list.capacity());

        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");

        assertEquals(10,list.capacity());

        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");
        list.add("Whatever");

        assertEquals(20,list.capacity());
    }
}
