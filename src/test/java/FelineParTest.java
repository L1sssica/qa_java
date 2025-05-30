import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParTest {

    private Feline feline = new Feline();

    @Parameterized.Parameter
    public int inputKittensCount;

    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Parameterized.Parameters(name = "Тут тестовый данные от 1 до 10")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 1},
                {0, 0},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void testGetKittensWithCount() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }

}
