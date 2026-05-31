import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test{
    @Test
    void TestThatgetIndicesToSumAddsReturns0And1(){
        int[] array = {2, 7, 11, 15};
        int[] result = Task1.getIndicesToSum(array, 9);
        int[] expected = {0, 1};
        assertArrayEquals(expected, result);
    }
}
