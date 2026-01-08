package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormRemoteTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Открыть форму", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Заполнить все поля формы", () -> {
            $("#firstName").setValue("Daria");
            $("#lastName").setValue("Test");
            $("#userEmail").setValue("daria@test.com");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("7999111223");

            //выбор даты в календаре
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__year-select").selectOption("1998");
            $("div[aria-label='Choose Saturday, January 31st, 1998']").click();

            $("#subjectsInput").setValue("Math").pressEnter();
            $("#subjects-label").click();

            $("#hobbiesWrapper").$(byText("Music")).click();

            //загрузка файла
            $("#uploadPicture").uploadFromClasspath("test.jpg");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();

            $("#currentAddress").setValue("Lenina Street 102");
        });
        step("Нажать кнопку Submit", () -> {
            $("#submit").click();
        });
        step("Проверка заполненной формы", () -> {
            $(".table-responsive").shouldHave(text("Daria Test"));
            $(".table-responsive").shouldHave(text("daria@test.com"));
            $(".table-responsive").shouldHave(text("Female"));
            $(".table-responsive").shouldHave(text("7999111223"));
            $(".table-responsive").shouldHave(text("31 January,1998"));
            $(".table-responsive").shouldHave(text("Maths"));
            $(".table-responsive").shouldHave(text("Music"));
            $(".table-responsive").shouldHave(text("test.jpg"));
            $(".table-responsive").shouldHave(text("Lenina Street 102"));
            $(".table-responsive").shouldHave(text("NCR Delhi"));

        });


    }
}
