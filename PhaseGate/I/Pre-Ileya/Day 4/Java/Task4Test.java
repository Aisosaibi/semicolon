import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test{
    @Test
    void TestThatonlyConsonantFunctionReturnsflyonly(){
        String[] input = {"pie", "fly", "rat"};
//	    String[] expected = {{"fly"} {"pie, rat"}};
        String[] expected = {"fly"};
	    String[] result = Task4.onlyConsonant(input);
	    assertArrayEquals(expected, result);
    }

//    @Test
//    void TestThatminMaxRangeFunctionThrowsIllegalArgumentException(){
//        String[] array = {10, 10};
//        with assertThrows IllegalArgumentException(ValueError):
//            minMaxRange(array);
//
//	    assertThrows(IllegalArgumentException.class, ()-> {Task3.minMaxRange(array);});
//    }
}
