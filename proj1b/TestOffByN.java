import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    static OffByN offBy5 = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(palindrome.isPalindrome("abf", offBy5));
        assertTrue(palindrome.isPalindrome("abchgf", offBy5));
        assertFalse(palindrome.isPalindrome("aaa", offBy5));
    }

    @Test
    public void testOffByN1() {
        assertFalse(palindrome.isPalindrome("aaazzz", offBy5));
        assertTrue(palindrome.isPalindrome("a", offBy5));
        assertTrue(palindrome.isPalindrome("", offBy5));
    }
}
