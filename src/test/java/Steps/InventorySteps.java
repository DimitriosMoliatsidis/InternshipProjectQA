package Steps;

import Pages.InventoryPage;
import Pages.LoginPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InventorySteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Step
    public void isOnInventoryPage(){

        loginPage.open();
        loginPage.doLoginRightCredencials();
        assertThat(loginPage.inventoryPageIsVisible()).isTrue();
    }

    @Step
    public void productTitlesShown(){
        for(int i=0;i<6;i++){
            switch (i) {
                case 0:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Sauce Labs Bike Light");
                    break;
                case 1:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Sauce Labs Bolt T-Shirt");
                    break;
                case 2:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Sauce Labs Onesie");
                    break;
                case 3:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Test.allTheThings() T-Shirt (Red)");
                    break;
                case 4:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Sauce Labs Backpack");
                    break;
                case 5:
                    assertThat(inventoryPage.productTitle(i)).isEqualTo("Sauce Labs Fleece Jacket");
                    break;

            }
        }
    }


    public void productsHavePrice() {
        List<WebElement> elements = inventoryPage.productsShown();
        for (int i = 0; i < elements.size(); i++) {
            assertThat(
                    elements.get(i).findElement(By.className("inventory_item_price")).isDisplayed());

        }
    }

    public void productsHaveDescription() {
        List<WebElement> elements = inventoryPage.productsShown();
        for (int i = 0; i < elements.size(); i++) {
            assertThat(
                    elements.get(i).findElement(By.className("inventory_item_description")).isDisplayed());
        }
    }


    public void productsHaveCartButton() {
        List<WebElement> elements = inventoryPage.productsShown();
        for (int i = 0; i < elements.size(); i++) {
            assertThat(
                    elements.get(i).findElement(By.cssSelector("[class='btn btn_primary btn_small btn_inventory']")).isDisplayed());
        }
    }


    public void isProductPriceCorrect() {
        List<WebElement> elements = inventoryPage.productsShown();
        for (int i = 0; i < elements.size(); i++) {
            switch (i) {
                case 0:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$29.99");
                    break;
                case 1:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$9.99");
                    break;
                case 2:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$15.99");
                    break;
                case 3:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$49.99");
                    break;
                case 4:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$7.99");
                    break;
                case 5:
                    assertThat(elements.get(i).findElement(By.cssSelector("[class='inventory_item_price']")).getText()).isEqualTo("$15.99");
                    break;

            }
        }
    }
}
