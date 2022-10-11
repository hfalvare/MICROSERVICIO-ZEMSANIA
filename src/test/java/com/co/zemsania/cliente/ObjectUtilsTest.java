package com.co.zemsania.cliente;



import com.co.zemsania.cliente.domain.model.utils.ObjectUtils;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjectUtilsTest {

    @Test
    public void testIsNullOrEmpty() {
        assertTrue(ObjectUtils.isNullOrEmpty(null));
    }

    @Test
    public void testIsNullOrEmptyWithEmptyString() {
        assertTrue(ObjectUtils.isNullOrEmpty(""));
    }

    @Test
    public void testIsNullOrEmptyWithEmptyArray() {
        assertTrue(ObjectUtils.isNullOrEmpty(new String[]{}));
    }

    @Test
    public void testIsNullOrEmptyWithList() {
        assertTrue(ObjectUtils.isNullOrEmpty(Collections.emptyList()));
    }

    @Test
    public void testIsNullOrEmptyWithString() {
        assertFalse(ObjectUtils.isNullOrEmpty("Test"));
    }

    @Test
    public void testIsEmptyOneObject() {
        Object object = null;
        assertTrue(ObjectUtils.isEmpty(object));
    }

    @Test
    public void testIsEmptyManyObjects() {
        Object[] objects = null;
        assertTrue(ObjectUtils.isEmpty(objects));
    }

    @Test
    public void testIsEmptyOneObjectWithEmptyString() {
        assertTrue(ObjectUtils.isEmpty(""));
    }

    @Test
    public void testIsEmptyOneObjectWithSomeEmptyObjects() {
        assertTrue(ObjectUtils.isEmpty("Test", Collections.emptyIterator(), new String[]{}));
    }

    @Test
    public void testNonNullOrEmpty() {
        assertTrue(ObjectUtils.nonNullOrEmpty("Tests"));
    }

    @Test
    public void testNonNullOrEmptyWithNullValue() {
        assertFalse(ObjectUtils.nonNullOrEmpty(null));
    }

    @Test
    public void testNonNullOrEmptyWithEmptyValue() {
        assertFalse(ObjectUtils.nonNullOrEmpty(""));
    }

    @Test
    public void testNonNullOrEmptyWithEmptyCollection() {
        assertFalse(ObjectUtils.nonNullOrEmpty(Collections.emptyList()));
    }
}
