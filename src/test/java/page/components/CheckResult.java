package page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResult {
    public static SelenideElement outputTextForm = $("#output");

    public void checkFullFillPracticeForm(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }
    public void checkNegativeTest() {
        $(".was-validated").shouldBe(visible);
        $(".table-responsive").shouldNot(visible);

    }

    public void checkTextForm(String value) {
        outputTextForm.shouldHave(text(value));
    }
}
