import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class HippodromeTest {

    @Test
    void testHippodromeNullSource() {

        Throwable exception =  Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Hippodrome(null));
        Assertions.assertEquals("Horses cannot be null.", exception.getMessage());

    }
@Test
    void testHippodromeEmptyList() {
    List<Horse> list = new ArrayList<>();

        Throwable exception =  Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Hippodrome(list));
        Assertions.assertEquals("Horses cannot be empty.", exception.getMessage());

    }

    @Test
    void testEqualsList(){
        List<Horse> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            list.add(new Horse("Hname"+i, 30+i, 100+i ));
        }
        Hippodrome hippodrome = new Hippodrome(list);
        Assertions.assertEquals(list, hippodrome.getHorses());
    }

    @Test
    void testMoveMethod(){
            List<Horse> list = new ArrayList<>();
            for (int i = 1; i <= 50; i++) {
                list.add(Mockito.mock(Horse.class));
            }

            Hippodrome hippodrome = new Hippodrome(list);
            hippodrome.move();

        for (Horse horse:list) {
            Mockito.verify(horse, Mockito.only()).move();
        }
    }

    @Test
    void getWinnerTest(){
            List<Horse> list = new ArrayList<>();
            for (int i = 1; i <= 7; i++) {
                list.add(new Horse("Hname"+i, 30+i, 100+i ));
            }

            Hippodrome hippodrome = new Hippodrome(list);
            Horse horseReturn = hippodrome.getWinner();
            Assertions.assertSame(list.get(6), horseReturn);
    }




}
