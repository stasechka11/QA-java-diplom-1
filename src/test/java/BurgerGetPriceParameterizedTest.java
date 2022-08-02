import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


@RunWith(Parameterized.class)
public class BurgerGetPriceParameterizedTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    private final int ingredientCount;
    private final float expectedPrice;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public BurgerGetPriceParameterizedTest(int ingredientCount, float expectedPrice) {
        this.ingredientCount = ingredientCount;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerIngredients() {
        return new Object[][]{
                {0, 200f},
                {1, 400f},
                {2, 600f}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void burgerGetPriceReturnsFloatTest() {
        for (int i = 0; i < ingredientCount; i++) {
            burger.addIngredient(ingredient);
        }
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.00f);
    }
}
