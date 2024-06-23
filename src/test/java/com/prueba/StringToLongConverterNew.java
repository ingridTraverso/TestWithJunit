package com.prueba;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*Codificar una funcion que convierta String numerico a long
* No se aceptan internalización
* Criterios de aceptacion:
* Se elevara un illegalArgumentException en caso de que no se cumpla con lo siguiente:
    - solo se admiten digitos
    - unicos signos (Caracteres especiales) admitidos:  + o - delante del digito
    - no se admiten letras
    - no se admiten espacios
    - no se admite null
    - no se admite ingresos vacios
    - no se admiten potencias 10e2
    - no se admiten numeros decimales
    - Longitud admitida x>-9223372036854775807 && x< 9223372036854775807
    - se admite digito 0 antes del resto.
*/
public class StringToLongConverterTest {
    public static void main(String[] args) {
        String inputString = "1234";
        long result = convert(inputString);
        System.out.println("El resultado es: " + result);
         }

    public static long convert(String inputString) {
        try {
            return Long.parseLong(inputString);

              } catch (IllegalArgumentException e) {
            System.out.println("Error de ingreso");
            return 0;
        }
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputIsNullThrowIllegalArgumentException() {
        String inputString = null;
        StringToLongConverterTest.convert(inputString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputIsEmptyThrowIllegalArgumentException() {
        String inputString = "";
        StringToLongConverterTest.convert(inputString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputHasEmptySpacesThrowIllegalArgumentException() {
        String inputString = " 856";
        StringToLongConverterTest.convert(inputString);
    }

    @Test
    public void testStringInputIsNullThrowNullPointerException() {
        try {
            String inputString = null;
            convert(inputString);
        }catch(NullPointerException e) {
        }
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputHasALetterThrowIllegalArgumentException() {
        String inputString = "857a";
        StringToLongConverterTest.convert(inputString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputHasSignsThrowIllegalArgumentException() {
        String inputString = "9223372036854775807!";
        StringToLongConverterTest.convert(inputString);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputIsADecimalNumberThrowIllegalArgumentException() {
        String inputString = "12.89";
        StringToLongConverterTest.convert(inputString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputIsGreaterThanAllowedThrowIllegalArgumentException() {
        String inputString = "9923372036854775807";
        StringToLongConverterTest.convert(inputString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringInputIsLessThanAllowedThrowIllegalArgumentException() {
        String inputString = "-9923372036854775808";
        StringToLongConverterTest.convert(inputString);
    }

    @Test
    public void testValidStringInput() {
        String inputString = "12345";
        long longEsperado = 12345L;
        long longResultado = StringToLongConverterTest.convert(inputString);
        assertEquals(longResultado, longEsperado);
    }

    @Test
    public void testValidNegativeStringInput() {
        String inputString = "-12345";
        long longEsperado = -12345L;
        long longResultado = StringToLongConverterTest.convert(inputString);
        assertEquals(longResultado, longEsperado);
    }

    @Test
    public void testValidStringInputWithLeadingZero() {
        String inputString = "012345";
        long longEsperado = 12345L;
        long longResultado = StringToLongConverterTest.convert(inputString);
        assertEquals(longResultado, longEsperado);
    }


}


