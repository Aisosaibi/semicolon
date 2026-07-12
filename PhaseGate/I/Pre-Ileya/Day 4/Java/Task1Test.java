import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test{
    @Test
    void TestThatpSumFunctionReturnsArrayContaining8AndMinus2(){
        int[] array = {8, 6, 12, 4, -2};
	    int[] expected = {8, -2};
	    int[] result = Task1.pSum(array, 6);
	    assertArrayEquals(expected, result);
    }

    @Test
    void TestThatpSumFunctionReturnsArrayContaining5and7(){
	    int[] array = {1, 2, 5, 7, 6, 8, 9};
	    int[] expected = {5, 7};
	    int[] result = Task1.pSum(array, 12);
	    assertArrayEquals(expected, result);
    }



}
