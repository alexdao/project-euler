import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilTest {
    @Test
    void isPrimeInteger() {
        assertEquals(true, Util.isPrime(2));
        assertEquals(true, Util.isPrime(3));
        assertEquals(false, Util.isPrime(4));
        assertEquals(true, Util.isPrime(5));
        assertEquals(false, Util.isPrime(0));
        assertEquals(false, Util.isPrime(-1));
        assertEquals(false, Util.isPrime(100));
    }

    @Test
    void isPrimeBigInteger() {
        assertEquals(true, Util.isPrime(new BigInteger("2")));
        assertEquals(true, Util.isPrime(new BigInteger("3")));
        assertEquals(false, Util.isPrime(new BigInteger("4")));
        assertEquals(true, Util.isPrime(new BigInteger("5")));
        assertEquals(false, Util.isPrime(new BigInteger("0")));
        assertEquals(false, Util.isPrime(new BigInteger("-1")));
        assertEquals(false, Util.isPrime(new BigInteger("100")));
    }

    @Test
    void isPalindroneInteger() {
        assertEquals(true, Util.isPalindrone(1));
        assertEquals(true, Util.isPalindrone(0));
        assertEquals(true, Util.isPalindrone(151));
        assertEquals(true, Util.isPalindrone(11));
        assertEquals(true, Util.isPalindrone(1234554321));
        assertEquals(false, Util.isPalindrone(12));
        assertEquals(false, Util.isPalindrone(1212));
    }

    @Test
    void isPalindroneString() {
        assertEquals(true, Util.isPalindrone("1"));
        assertEquals(true, Util.isPalindrone("0"));
        assertEquals(true, Util.isPalindrone("151"));
        assertEquals(true, Util.isPalindrone("11"));
        assertEquals(true, Util.isPalindrone("1234554321"));
        assertEquals(false, Util.isPalindrone("12"));
        assertEquals(false, Util.isPalindrone("1212"));
    }

    @Test
    void calcFactorial() {
        assertEquals(1, Util.calcFactorial(1));
        assertEquals(2, Util.calcFactorial(2));
        assertEquals(6, Util.calcFactorial(3));
        assertEquals(120, Util.calcFactorial(5));
        assertEquals(1, Util.calcFactorial(0));
    }

    @Test
    void simplifyFraction() {
        Util.Fraction testFraction1 = new Util.Fraction(8, 800);
        Util.Fraction testFraction2 = new Util.Fraction(3, 7);
        Util.Fraction testFraction3 = new Util.Fraction(-5, 10);
        Util.Fraction testFraction4 = new Util.Fraction(2, 4);

        testFraction1.simplifyFraction();
        testFraction2.simplifyFraction();
        testFraction3.simplifyFraction();
        testFraction4.simplifyFraction();

        assertEquals(1, testFraction1.getNumerator());
        assertEquals(100, testFraction1.getDenominator());
        assertEquals(3, testFraction2.getNumerator());
        assertEquals(7, testFraction2.getDenominator());
        assertEquals(1, testFraction4.getNumerator());
        assertEquals(2, testFraction4.getDenominator());
    }

    @Test
    void isPandigital() {
        assertEquals(true, Util.isPandigital(123456789));
        assertEquals(true, Util.isPandigital(12345));
        assertEquals(false, Util.isPandigital(112345678));
        assertEquals(true, Util.isPandigital(1));
        assertEquals(false, Util.isPandigital(124));
        assertEquals(false, Util.isPandigital(234));
    }

}