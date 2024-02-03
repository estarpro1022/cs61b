import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void test1() {
        assertTrue("same number", Flik.isSameNumber(10, 10));
        assertTrue(Flik.isSameNumber(15, 15));
        assertTrue(Flik.isSameNumber(100, 100));
        assertTrue(Flik.isSameNumber(128, 128));
        assertTrue("same number", Flik.isSameNumber(300, 300));
        assertTrue(Flik.isSameNumber(900, 900));
        assertTrue(Flik.isSameNumber(10000000, 10000000));
    }

    @Test
    public void test2() {
        assertFalse("not same number", Flik.isSameNumber(15, 20));
        assertFalse("not same number", Flik.isSameNumber(20, 25));
        assertFalse("not same number", Flik.isSameNumber(999, 1000));
    }
}
