package Pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
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


    public WebElement getSpecificProduct(int i) {
        WebElement product=$("[id='item_"+i+"_title_link']");
        System.out.println(product);
        return product;
    }
}
