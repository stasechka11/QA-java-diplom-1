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
import praktikum.IngredientType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private Burger burger;
    private final int ingredientCount;
    private Ingredient ingredient1;
    private Pattern pattern;

    public BurgerGetReceiptParameterizedTest(int ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerIngredients() {
        return new Object[][]{
                {0},
                {1},
                {2}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        Bun bun = new Bun("Black bun", 100);
        burger.setBuns(bun);
        ingredient1 = new Ingredient(IngredientType.FILLING, "meat", 200);
        pattern = Pattern.compile("(\\(==== .+ ====\\)\r\\n)(= .+ =\r\\n)*\\(==== .+ ====\\)\r\\n(\r\\nPrice: \\d+,\\d+\r\n)");
    }

    @Test
    public void burgerGetReceiptReturnsStringTest() {
        for (int i = 0; i < ingredientCount; i++) {
            burger.addIngredient(ingredient1);
        }

        String receipt = burger.getReceipt();

        Matcher matcher = pattern.matcher(receipt);

        Assert.assertTrue(matcher.matches());
    }
}
