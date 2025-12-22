package tests;


import org.junit.jupiter.api.Test;
import page.TextBoxPage;
import page.components.SkipBanners;


public class TextBoxTestsPageObject extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    SkipBanners skipBanners = new SkipBanners();

    @Test
    void fillFormTest() {

        textBoxPage.openPage();
        skipBanners.notVisibleBanners();
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
