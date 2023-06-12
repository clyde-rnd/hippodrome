import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseTest {

    @Test
    void testConstructorHorseNotNull() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse(null, 30, 1000);
                }
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\t", "\n"})
    void isNotBlankName(String string){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse(string, 30, 1000);
                }
        );
        assertEquals("Name cannot be blank.", exception.getMessage());

    }

    @Test
    void negativeSpeedTest(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("Name", -1, 1000);
                }
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());

    }

    @Test
    void negativeDistanceTest(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("Name", 30, -1000);
                }
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());

    }

    @Test
    void getNameTest(){
        Horse horse = new Horse("Name", 30, 1000);
        Assertions.assertEquals("Name", horse.getName());
    }
    @Test
    void getSpeedTest(){
        Horse horse = new Horse("Name", 30, 1000);
        Assertions.assertEquals(30, horse.getSpeed());
    }

    @Test
    void getDistanceTest(){
        Horse horse = new Horse("Name", 30, 1000);
        Assertions.assertEquals(1000, horse.getDistance());
        horse = new Horse("Name", 30);
        Assertions.assertEquals(0, horse.getDistance());
    }

   @Test
   void moveTest(){
       try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)) {
           Horse n = new Horse("Name", 30, 1000);
           //добавляем правило
           //utilities.verify(()->Horse.getRandomDouble(0.2, 0.9));
       }



   }
   @Test
    void tes(){
       try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)) {
           new Horse("Name", 30, 1000).move();
           //добавляем правило
           utilities.verify(()->Horse.getRandomDouble(0.2, 0.9));
       }
   }



}
