package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsPageObject extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage();
        textBoxPage.setUserNameInput("Daria");
        textBoxPage.setUserEmailInput("daria@test.com");
        textBoxPage.setCurrentAddressInput("Lenina Street 102");
        textBoxPage.setPermanentAddressInput("Nosova Street 333");
        textBoxPage.pressButton();

        textBoxPage.checkTextForm("Daria");
        textBoxPage.checkTextForm("daria@test.com");
        textBoxPage.checkTextForm("Lenina Street 102");
        textBoxPage.checkTextForm("Nosova Street 333");


    }
}
