import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {
    Burger burger;
    @Mock
    Ingredient ingredient;

    int ingredientsListSize;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void burgerAddIngredientTest() {
        ingredientsListSize = burger.ingredients.size();

        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredientsListSize + 1, burger.ingredients.size());
    }

    @Test
    public void burgerRemoveIngredientTest() {
        burger.addIngredient(ingredient);
        ingredientsListSize = burger.ingredients.size();

        burger.removeIngredient(0);
        Assert.assertEquals(ingredientsListSize - 1, burger.ingredients.size());
    }

    @Test
    public void burgerMoveIngredientTest() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(7), 200f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(7), 100f);
        burger.addIngredient(ingredient1);
        int indexOfIngredient1 = burger.ingredients.indexOf(ingredient1);

        burger.addIngredient(ingredient2);
        int indexOfIngredient2 = burger.ingredients.indexOf(ingredient2);

        burger.moveIngredient(0, 1);
        Assert.assertTrue(burger.ingredients.indexOf(ingredient1) == indexOfIngredient2 && burger.ingredients.indexOf(ingredient2) == indexOfIngredient1);
    }
}
