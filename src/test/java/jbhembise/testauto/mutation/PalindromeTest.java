package jbhembise.testauto.mutation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void when_palindrom_then_accept() {
        // GIVEN
        Palindrome palindrome = new Palindrome();

        // WHEN
        boolean isPalindrome = palindrome.isPalindrome("noon");

        // THEN
        assertTrue(isPalindrome);
    }

    @Test
    public void when_not_palindrom_then_reject() {
        // GIVEN
        Palindrome palindrome = new Palindrome();

        // WHEN
        boolean isPalindrome = palindrome.isPalindrome("box");

        // THEN
        assertFalse(isPalindrome);
    }

    @Test
    public void when_near_palindrom_then_reject() {
        // GIVEN
        Palindrome palindrome = new Palindrome();

        // WHEN
        boolean isPalindrome = palindrome.isPalindrome("neon");

        // THEN
        assertFalse(isPalindrome);
    }
}
