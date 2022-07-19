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
    Burger burger;

    Bun bun;

    int ingredientCount;
    Ingredient ingredient1;

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
        bun = new Bun("Black bun", 100);
        burger.setBuns(bun);
        ingredient1 = new Ingredient(IngredientType.FILLING, "meat", 200);
    }

    @Test
    public void burgerGetReceiptReturnsStringTest() {
        for (int i = 0; i < ingredientCount; i++) {
            burger.addIngredient(ingredient1);
        }

        String receipt = burger.getReceipt();

        Pattern pattern = Pattern.compile("(\\(==== .+ ====\\)\r\\n)(= .+ =\r\\n)*\\(==== .+ ====\\)\r\\n(\r\\nPrice: \\d+,\\d+\r\n)");
        Matcher matcher = pattern.matcher(receipt);

        Assert.assertTrue(matcher.matches());
    }
}
