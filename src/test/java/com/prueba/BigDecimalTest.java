package com.prueba;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BigDecimalTest {

        @Test
        public void testLastOfListIsNullThrowsIllegalArgumentException() {
            try {
                TestEquality.average(List.of(new BigDecimal("1.0"), new BigDecimal("2.0"), null));
                Assert.fail("Debería haberse elevado IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                // Excepción esperada
            }
        }

        @Test
        public void testEmptyListThrowsIllegalArgumentException() {
            try {
                TestEquality.average(List.of());
                Assert.fail("Debería haberse elevado IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                // Excepción esperada
            }
        }

        @Test
        public void testNullListThrowsIllegalArgumentException() {
            try {
                TestEquality.average(null);
                Assert.fail("Debería haberse elevado IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                // Excepción esperada
            }
        }

        @Test
        public void testValidList() {
            BigDecimal result = TestEquality.average(List.of(new BigDecimal("1.0"), new BigDecimal("2.0"), new BigDecimal("3.0")));
            Assert.assertEquals(new BigDecimal("10.0"), result);
        }
    }


