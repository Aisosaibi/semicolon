import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Test{
    @Test
    void TestThatcountVowelsAndConsonantsReturnsAnArrayOfVowelsAndConsonants(){
        String input = "Hello - World";
        String[] result = Task2.countVowelAndConsonants(input);
        String[][] expected = {{"vowels", 3}, {"consonants", 7}};
        assertArrayEquals(expected, result);
    }

}
