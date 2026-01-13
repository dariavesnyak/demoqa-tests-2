package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {

    public void notVisibleBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
