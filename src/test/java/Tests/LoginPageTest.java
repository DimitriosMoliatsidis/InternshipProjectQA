package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class LoginPageTest {
    @Steps
    LoginSteps loginSteps;

    @Managed(driver = "chrome")
    WebDriver driver;


    @Test
    public void appLoginTestWithRightCredencials(){
        loginSteps.isOnLoginPage();
        loginSteps.loginWithRightCredentials();
        loginSteps.userShouldBeLogedIn();

    }
    @Test
    public void appLoginTestWithLockedCredentials() throws InterruptedException {
        loginSteps.isOnLoginPage();
        loginSteps.loginWithLockedCredentials();
        loginSteps.shouldShowLockedError();

    }
}
