import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListIntegersFromMinimumToMaximumExclusiveTest{
    @Test
    void TestThatminMaxRangeFunctionReturns0till9only(){
        int[] array = {0, 10};
	    int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	    int[] result = ListIntegersFromMinimumToMaximumExclusive.minMaxRange(array);
	    assertArrayEquals(expected, result);
    }

    @Test
    void TestThatminMaxRangeFunctionThrowsIllegalArgumentException(){
        int[] array = {10, 10};
//        with assertThrows IllegalArgumentException(ValueError):
//            minMaxRange(array);

	    assertThrows(IllegalArgumentException.class, ()-> {ListIntegersFromMinimumToMaximumExclusive.minMaxRange(array);});
    }
}
