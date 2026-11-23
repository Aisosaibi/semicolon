import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest{

    @Test
    void TestThatIfAnyArrayElementIsZeroItReturnsAvailableSpaceMessage(){
        String expected = "There are free slots!";
        String result = ParkingLot.parkingLot();
        assertEquals(expected, result);
    }

    @Test
    void TestThatIfNoArrayElementIsZeroItReturnsNoSpaceMessage(){
        String expected = "There are no slots!";
        String result = ParkingLot.parkingLot();
        assertEquals(expected, result);
    }

//    void TestThatUserCannotParkInSpaceThatIsOccupied{
//        int
//    }

//    void TestThatUserCannot
}
