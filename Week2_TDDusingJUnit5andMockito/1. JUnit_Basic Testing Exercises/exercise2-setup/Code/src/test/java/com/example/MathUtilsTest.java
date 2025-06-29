package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils utils = new MathUtils();
        assertEquals(9, utils.add(4, 5));
    }

    @Test
    public void testMultiply() {
        MathUtils utils = new MathUtils();
        assertEquals(20, utils.multiply(4, 5));
    }

    @Test
    public void testIsEvenTrue() {
        MathUtils utils = new MathUtils();
        assertTrue(utils.isEven(6));
    }

    @Test
    public void testIsEvenFalse() {
        MathUtils utils = new MathUtils();
        assertFalse(utils.isEven(7));
    }
}
