import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBase {
    @Test
    void testBaseConvertToBaseTen() {
        assertEquals(6, Base.convertToBaseTen(11, 5));
        assertEquals(24, Base.convertToBaseTen(40, 6));
        assertEquals(8, Base.convertToBaseTen(1000, 2));
    }

    @Test
    void testBaseConvertFromBaseTen() {
        assertEquals(11, Base.convert(6, 5));
        assertEquals(40, Base.convert(24, 6));
        assertEquals(1000, Base.convert(8, 2));
    }

    @Test
    void testBaseConvertFromCurrentBaseToTargetBase() {
        assertEquals(10, Base.convert(2, 4, 2));
        assertEquals(40, Base.convert(26, 9, 6));
        assertEquals(8, Base.convert(13, 5, 10));
        assertEquals(1750, Base.convert(1000, 8));
    }

    @Test
    void testBaseConvertThrowsExceptionIfAnyBaseIsGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> Base.convert(2, 4, 11));
        assertThrows(IllegalArgumentException.class, () -> Base.convert(10, 11, 4));
        assertThrows(IllegalArgumentException.class, () -> Base.convert(9, 10, 11));

    }
}
