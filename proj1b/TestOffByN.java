import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    static OffByN offBy5 = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(palindrome.isPalindrome("abc", offBy5));
        assertTrue(palindrome.isPalindrome("aaabbb", offBy5));
        assertTrue(palindrome.isPalindrome("abcdef", offBy5));
        assertTrue(palindrome.isPalindrome("bbb", offBy5));
        assertTrue(palindrome.isPalindrome("aba", offBy5));
    }

    @Test
    public void testOffByN1() {
        assertFalse(palindrome.isPalindrome("aaazzz", offBy5));
        assertTrue(palindrome.isPalindrome("a", offBy5));
        assertTrue(palindrome.isPalindrome("", offBy5));
    }
}
