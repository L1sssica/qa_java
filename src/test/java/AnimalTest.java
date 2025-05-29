

import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AnimalTest {

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodForUnknownTypeThrowsException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный вид");
    }

    @Test
    public void testGetFoodExceptionMessage() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный вид");
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    public void testGetFoodIsCaseSensitive() throws Exception {
        Animal animal = new Animal();
        try {
            animal.getFood("хищник");
            fail("Expected an Exception to be thrown for lowercase input");
        } catch (Exception e) {
            // expected
        }

        try {
            animal.getFood("ТРАВОЯДНОЕ");
            fail("Expected an Exception to be thrown for uppercase input");
        } catch (Exception e) {
            // expected
        }
    }
}
