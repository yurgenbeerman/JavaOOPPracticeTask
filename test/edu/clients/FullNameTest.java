package edu.clients;

import org.junit.*;
import org.junit.Assert.*;

/**
 * Created by yurii.pyvovarenko on 3/11/14.
 */
public class FullNameTest {
    @Test
    public void shouldToString_whenToString() throws Exception {
        //given
        FullName fn = new FullName("Surname", "name", "secondName");

        //when

        //then
        org.junit.Assert.assertEquals("Should be equal strings", "Surname name secondName", fn.toString());

    }
}
