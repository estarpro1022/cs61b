import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
//    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        String a = "abc";
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome1() {
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("aabbbbaa"));
        assertTrue(palindrome.isPalindrome("ababbaba"));
        assertTrue(palindrome.isPalindrome("dad"));
    }

    @Test
    public void testIsPalindrome2() {
        assertFalse(palindrome.isPalindrome("ababab"));
        assertFalse(palindrome.isPalindrome("bababa"));
        assertFalse(palindrome.isPalindrome("cat"));
    }

    @Test
    public void testIsPalindrome3() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("ab"));
    }

    @Test
    public void testIsPalindromeWithComparator1() {
        assertTrue(palindrome.isPalindrome("abbb", offByOne));
        assertTrue(palindrome.isPalindrome("cab", offByOne));
        assertTrue(palindrome.isPalindrome("hellfg", offByOne));
        assertTrue(palindrome.isPalindrome("heh", offByOne));
        assertTrue(palindrome.isPalindrome("ababab", offByOne));
    }

    @Test
    public void testIsPalindromeWithComparator2() {
        assertFalse(palindrome.isPalindrome("ababac", offByOne));
        assertFalse(palindrome.isPalindrome("ababac", offByOne));
        assertFalse(palindrome.isPalindrome("ac", offByOne));
        assertFalse(palindrome.isPalindrome("bbbddd", offByOne));
        assertFalse(palindrome.isPalindrome("aefc", offByOne));
    }

    @Test
    public void testIsPalindromeWithComparator3() {
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
    }
}
