package com.prueba;

public class StringToLongConverterTest2 {

    public static long convertStringToLong(String numberString) {
        if (numberString == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        numberString = numberString.trim();
        if (numberString.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty");
        }

        boolean isNegative = false;
        int startIndex = 0;

        if (numberString.charAt(0) == '-') {
            isNegative = true;
            startIndex++;
        } else if (numberString.charAt(0) == '+') {
            startIndex++;
        }

        long result = 0;
        for (int i = startIndex; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Invalid character found: " + c);
            }

            int digit = c - '0';
            result = result * 10 + digit;

            // Check for overflow
            if (isNegative && -result < Long.MIN_VALUE) {
                throw new IllegalArgumentException("Number too small: " + numberString);
            } else if (!isNegative && result > Long.MAX_VALUE) {
                throw new IllegalArgumentException("Number too large: " + numberString);
            }
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        String inputString = "12345";
        long result = convertStringToLong(inputString);
        System.out.println("El resultado es: " + result);
    }
}




