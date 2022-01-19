package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.InventorySteps;

@RunWith(SerenityRunner.class)
public class InventoryPageTest {

    @Steps
    InventorySteps inventorySteps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void areTheProductsShown() {
        inventorySteps.isOnInventoryPage();

        inventorySteps.productTitlesShown();
    }

    @Test
    public void isTheInventoryShownCorrectly(){
        inventorySteps.isOnInventoryPage();
        inventorySteps.productsHavePrice();
        System.out.println("Price OK");
        inventorySteps.productsHaveDescription();
        System.out.println("Description Ok");
        inventorySteps.productsHaveCartButton();
        System.out.println("Button Ok");
    }

    @Test
    public void arePricesCorrect(){
        inventorySteps.isOnInventoryPage();
        inventorySteps.productsHavePrice();

        inventorySteps.isProductPriceCorrect();

    }

}
