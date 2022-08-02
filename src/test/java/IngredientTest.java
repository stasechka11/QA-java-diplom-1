import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

public class IngredientTest {
    private Ingredient ingredient;
    private String ingredientNameExpected;
    private float ingredientPriceExpected;
    private IngredientType ingredientTypeExpected;

    @Before
    public void setUp() {
        ingredientNameExpected = RandomStringUtils.randomAlphabetic(7);
        Random r = new Random();
        ingredientPriceExpected = r.nextFloat();
        ingredientTypeExpected = praktikum.IngredientType.values()[r.nextInt(IngredientType.values().length)];

        ingredient = new Ingredient(ingredientTypeExpected, ingredientNameExpected, ingredientPriceExpected);
    }

    @Test
    public void ingredientGetNameReturnsText() {
        Assert.assertEquals(ingredientNameExpected, ingredient.getName());
    }

    @Test
    public void ingredientGetPriceReturnsFloat() {
        Assert.assertEquals(ingredientPriceExpected, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetTypeReturnsEnumValue() {
        Assert.assertEquals(ingredientTypeExpected, ingredient.getType());
    }
}
