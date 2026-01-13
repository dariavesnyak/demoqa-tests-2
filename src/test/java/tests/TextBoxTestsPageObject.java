package tests;


import org.junit.jupiter.api.Test;
import page.TextBoxPage;
import helpers.JsSnippets;


public class TextBoxTestsPageObject extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    JsSnippets jsSnippets = new JsSnippets();

    @Test
    void fillFormTest() {

        textBoxPage.openPage();
        jsSnippets.notVisibleBanners();
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
