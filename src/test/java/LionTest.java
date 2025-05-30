import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный пол", felineMock);
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        when(felineMock.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getKittens();
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = List.of(":Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testGetFoodCallsFelineMethodWithCorrectArgument() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        lion.getFood();
        verify(felineMock).getFood("Хищник");
    }
}