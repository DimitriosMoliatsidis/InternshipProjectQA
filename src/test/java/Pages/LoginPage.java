package Pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;


import java.time.Duration;

import static org.assertj.core.api.Assertions.*;



@DefaultUrl("https://saucedemo.com")
public class LoginPage extends PageObject {

    public void  doLoginRightCredencials(){
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
    }
    public void  doLoginLockedCredencials(){
        $("#user-name").sendKeys("locked_out_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
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
