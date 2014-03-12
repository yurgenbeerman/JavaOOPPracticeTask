package edu.clients;

import org.junit.*;
import org.junit.Assert.*;

/**
 * Created by yurii.pyvovarenko on 3/11/14.
 */
public class FullNameTest {
    @Test
    public void shouldToString() throws Exception {
        //given
        FullName fn = new FullName("Surname", "name", "secondName");

        //when

        //then
        org.junit.Assert.assertEquals("Should be equal strings", "Surname name secondName", fn.toString());
    }

    @Test
    public void shouldBeNullToString_whenNull() throws Exception {
        //given
        String s;

        //when
        FullName fn = new FullName(null, null, null);
        s = "";

        //then
        org.junit.Assert.assertEquals("", fn.toString());
    }

    @Test
    public void FullNameConstructorTest() throws Exception {
        //when
        FullName fn = new FullName("Surn ame", "na me", "second Name");

        //then
        org.junit.Assert.assertEquals("Should be equal strings", "Surn ame na me second Name", fn.toString());
    }
}
