import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensWithoutParameters() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("1 котенок по умолчанию",
                expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithParameters() {
        Feline feline = new Feline();
        int expectedKittens = 6;
        int actualKittens = feline.getKittens(6);
        assertEquals("возвращаться должно заданное количество котяток)",
                expectedKittens, actualKittens);
    }
}
