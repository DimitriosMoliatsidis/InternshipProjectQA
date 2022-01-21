package Pages;




import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


import java.time.Duration;

import static org.assertj.core.api.Assertions.*;



@DefaultUrl("https://saucedemo.com")
public class LoginPage extends PageObject {
    private By USERNAME =  By.id("user-name");
    private By PASSWORD = By.id("password");
    private By LOGINBUTTON= By.id("login-button");

    public void  doLoginRightCredencials(){
        $(USERNAME).sendKeys("standard_user");
        $(PASSWORD).sendKeys("secret_sauce");
        $(LOGINBUTTON).click();
    }
    public void  doLoginLockedCredencials(){
        $(USERNAME).sendKeys("locked_out_user");
        $(PASSWORD).sendKeys("secret_sauce");
        $(LOGINBUTTON).click();
    }
    public Boolean inventoryPageIsVisible() {
        return $("#inventory_container").isPresent();
    }
    public String loginErrorText() {
        String errorText=withTimeoutOf(Duration.ofSeconds(2)).waitFor("[data-test='error']").getText();
        System.out.println(errorText);
        return errorText;
    }
}
