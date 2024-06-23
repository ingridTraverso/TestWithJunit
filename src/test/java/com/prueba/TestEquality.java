import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class TestEquality {
    public BigDecimal average(List<BigDecimal> numbers) {

        if (numbers == null) throw new IllegalArgumentException();
        if (numbers.isEmpty()) throw new IllegalArgumentException();
        return new BigDecimal(10.0);
    }

    @Test
    public void testAverageOfThreeTwoOneIsTwo() {
        org.junit.Assert.assertEquals(
                average(List.of(new BigDecimal("1.0"), new BigDecimal("2.0"), new BigDecimal("3.0"))),
                new BigDecimal("2.0"));
    }

    @Test
    public void testNullListThrowIllegalArgumentException() {
        try {
            average(null);
            org.junit.Assert.fail("Debería haberse elevado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            ;
        }
    }

    @Test
    public void testOneOfSixisNullThrowIllegalArgumentException(){
        List<BigDecimal> numbers = new ArrayList<>();
        Random random = new Random();
        numbers.add(BigDecimal.valueOf(random.nextDouble()));
        try {
            if (numbers.get(random.nextInt(numbers.size()))==null);
            org.junit.Assert.fail("Debería haberse elevado IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            ;

        }
    }


    @Test
    public void testEmptyListThrowsIllegalArgumentException() {
        try {
            average(new ArrayList<>());
            org.junit.Assert.fail("Debería haberse elevado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            ;
        }
    }
    @Test
    public void testFirstOfListIsNullThrowsIllegalArgumentException() {
        List<BigDecimal> numbers = new ArrayList<>(); // PAG: Buscar modo de crear lista nueva con una única línea
        numbers.add(new BigDecimal("1.0"));
        numbers.add(new BigDecimal("2.0"));
        numbers.add(null);
        try {
            if (numbers.get(numbers.indexOf(1)) == null) ;
            org.junit.Assert.fail("Debería haberse elevado IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            ;

        }
    }
    @Test
    public void testLastOfListIsNullThrowsIllegalArgumentException() {
        List<BigDecimal> numbers = new ArrayList<>();
        numbers.add(new BigDecimal("1.0"));
        numbers.add(new BigDecimal("2.0"));
        numbers.add(null);
        //BigDecimal lastNumber;
        try {
            //average(lastNumber = BigDecimal.valueOf(numbers.lastIndexOf(null)));
            // if (numbers.get(numbers.size() - 1) == null) ;
            //  average( newList( newRandomBigDecimal(), newRandomBigDecimal(), null ));
            org.junit.Assert.fail("Debería haberse elevado IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            ;
        }



    }


}
