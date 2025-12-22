package page.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SkipBanners {

    public void notVisibleBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
