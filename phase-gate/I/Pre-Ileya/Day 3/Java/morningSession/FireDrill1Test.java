import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FireDrill1Test{

    @Test
    public void testThatnumberOfUsersReturnsTwoUsers(){
        int expected = 2;
        String[] users = {"Ahmed", "Musa"};
        int actual = FireDrill1.numberOfUsers(users);
        assertEquals(expected, actual);
    }

    @Test
    public void testThatnumberOfUsersReturnsZeroUsers(){
        int expected = 0;
        String[] users = new String[5];
        int actual = FireDrill1.numberOfUsers(users);
        assertEquals(expected, actual);
    }

    @Test
    public void testThatusernamesReturnsTwoUsernames(){
        String[] expected = {"Ahmed", "Musa"};
        String[] users = {"Ahmed", "Musa", null};
        String[] actual = FireDrill1.usernames(users);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testThatusernamesReturnsNullUsernames(){
        String[] expected = null;
        String[] users = new String[5];
        String[] actual = FireDrill1.usernames(users);
        assertArrayEquals(expected, actual);
    }

}
