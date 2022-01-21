package Pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InventoryPage extends PageObject {

    public List<WebElement> productsShown(){
       List<WebElement> elements= new ArrayList<WebElement>();
        for(int i=0; i<6; i++)
        elements.add(findAll(By.className("inventory_item")).get(i));
        return elements;
    }


    public String productTitle(int i){
        String productTitle=$("[id='item_"+i+"_title_link'] [class]").getText();
        System.out.println(productTitle);
        return productTitle;

    }
    public boolean isOnProductInformationPage(){
        boolean flag = false;
        flag= $("[class='inventory_details_container']").isPresent();
        return flag;
    }
    public void returnToIncentoryPage(){
        $("[id='back-to-products']").click();
    }


    public WebElement getWholeProduct(int i) {

        return $$("[class='inventory_item").get(i);
    }
    @Step
    public void goToCart() {
        $("[class='shopping_cart_link']").click();
    }
    public void returnFromCart() {
        $("[class='btn btn_secondary back btn_medium']").click();
    }

    public void checkIfProductGotInCart(int i) {
        switch (i) {
            case 0:
                assertThat($("[id='item_4_title_link']").isDisplayed()).isTrue();
                break;
            case 1:
                assertThat($("[id='item_0_title_link']").isDisplayed()).isTrue();
                break;
            case 2:
                assertThat($("[id='item_1_title_link']").isDisplayed()).isTrue();
                break;
            case 3:
                assertThat($("[id='item_5_title_link']").isDisplayed()).isTrue();
                break;
            case 4:
                assertThat($("[id='item_2_title_link']").isDisplayed()).isTrue();
                break;
            case 5:
                assertThat($("[id='item_3_title_link']").isDisplayed()).isTrue();
                break;

        }
    }
    public void getProductInCartFromDescription(){
        $("[class='btn btn_primary btn_small btn_inventory']").click();
    }
}
