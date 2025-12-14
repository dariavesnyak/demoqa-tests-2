import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Daria");
        $("#userEmail").setValue("daria@test.com");
        $("#currentAddress").setValue("Lenina Street 102");
        $("#permanentAddress").setValue("Nosova Street 333");
        $("#submit").click();

    }
}
