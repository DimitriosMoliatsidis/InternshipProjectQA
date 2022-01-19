package Steps;

import Pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private LoginPage loginPage;

    @Step
    public void isOnLoginPage(){

        loginPage.open();

    }

    @Step
    public void loginWithRightCredentials(){
        loginPage.doLoginRightCredencials();
    }
    public void loginWithLockedCredentials(){
        loginPage.doLoginLockedCredencials();
    }
    @Step
    public void userShouldBeLogedIn(){
        assertThat(loginPage.inventoryPageIsVisible()).isTrue();
    }
    @Step
    public void shouldShowLockedError(){
        assertThat(loginPage.loginErrorText()).isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }
}
