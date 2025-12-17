import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {


        open("/automation-practice-form");
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
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#currentAddress").setValue("Lenina Street 102");
        $("#submit").click();

        //Проверка заполненной формы
        $(".table-responsive").shouldHave(text("Daria Test"));
        $(".table-responsive").shouldHave(text("daria@test.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("7999111223"));
        $(".table-responsive").shouldHave(text("31 January,1998"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Lenina Street 102"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));



    }
}
