import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {  //Метод должен возвращать звук "Мяу"
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {  //Метод должен возвращать список еды
        List<String> expectedFood = Arrays.asList("Птицы", "Рыба", "Животные");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка"));
        cat.getFood();
    }
}