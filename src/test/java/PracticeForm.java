import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.empty;
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
        File fileToUpload = new File("src/test/resources/test.jpg");

        open("/automation-practice-form");
        $("#firstName").setValue("Daria");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("daria@test.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("7999111223");

        //выбор даты в календаре
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1998");
        $("div[aria-label='Choose Saturday, January 31st, 1998']").click();

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjects-label").click();

        $(byText("Music")).click();

        //загрузка файла
        $("#uploadPicture").uploadFile(fileToUpload);

        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#currentAddress").setValue("Lenina Street 102");
        $("#submit").click();

        //Проверка заполненной формы
        $x("//table/tbody/tr[1]/td[2]").shouldHave(text("Daria Test"));
        $x("//table/tbody/tr[2]/td[2]").shouldHave(text("daria@test.com"));
        $x("//table/tbody/tr[3]/td[2]").shouldHave(text("Female"));
        $x("//table/tbody/tr[4]/td[2]").shouldHave(text("7999111223"));
        $x("//table/tbody/tr[5]/td[2]").shouldHave(text("31 January,1998"));
        $x("//table/tbody/tr[6]/td[2]").shouldHave(text("Maths"));
        $x("//table/tbody/tr[7]/td[2]").shouldHave(text("Music"));
        $x("//table/tbody/tr[8]/td[2]").shouldHave(text("test.jpg"));
        $x("//table/tbody/tr[9]/td[2]").shouldHave(text("Lenina Street 102"));
        $x("//table/tbody/tr[10]/td[2]").shouldHave(text("Haryana Karnal"));


    }
}
