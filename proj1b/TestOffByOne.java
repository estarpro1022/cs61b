import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void test0() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('c', 'd'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('C', 'B'));
        assertTrue(offByOne.equalChars('y', 'z'));
    }

    @Test
    public void test1() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('b', 'z'));
        assertFalse(offByOne.equalChars('c', 'c'));
        assertFalse(offByOne.equalChars('D', 'D'));
        assertFalse(offByOne.equalChars('c', 'a'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('D', 'c'));
    }

    @Test
    public void test2() {
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('%', '%'));
    }
}
