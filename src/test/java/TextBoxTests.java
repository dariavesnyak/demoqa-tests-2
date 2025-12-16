import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Daria");
        $("#userEmail").setValue("daria@test.com");
        $("#currentAddress").setValue("Lenina Street 102");
        $("#permanentAddress").setValue("Nosova Street 333");
        $("#submit").click();

        $("#output #name").shouldHave(text("Daria"));
        $("#output #email").shouldHave(text("daria@test.com"));
        $("#output #currentAddress").shouldHave(text("Lenina Street 102"));
        $("#output #permanentAddress").shouldHave(text("Nosova Street 333"));

    }
}
