package pl.dominisz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * http://dominisz.pl
 * 08.01.2018
 */
public class TimeUtilsTest {

    @Test
    public void timeUtilsTest() {
        Assertions.assertEquals("00:50", TimeUtils.format(50));
        Assertions.assertEquals("01:10", TimeUtils.format(70));
        Assertions.assertEquals("02:05", TimeUtils.format(125));
        Assertions.assertEquals("01:00:01", TimeUtils.format(3601));
    }
}
